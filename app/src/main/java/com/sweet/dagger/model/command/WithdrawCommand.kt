package com.sweet.dagger.model.command

import com.sweet.dagger.database.Database
import com.sweet.dagger.di.MaxAmount
import com.sweet.dagger.di.MinAmount
import com.sweet.dagger.model.Account
import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import com.sweet.dagger.model.limiter.WithdrawalLimiter
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(
    private val outPutter: OutPutter,
    private val account: Account,
    private val database: Database,
    @MinAmount
    private val minAmount: BigDecimal,
    @MaxAmount
    private val maxAmount: BigDecimal,
    private val withdrawalLimiter: WithdrawalLimiter
) : BigDecimalCommand() {

    override fun handleAmount(value: BigDecimal): Result {

        if (value > withdrawalLimiter.remainingWithdrawalLimit) {
            return Result.Invalid(
                message = "you may not withdraw $value; you may withdraw ${withdrawalLimiter.remainingWithdrawalLimit} more in this session",
            ).also {
                outPutter.print(it.message)
            }
        }

        if (value > maxAmount) {
            return Result.Invalid(message = "Max amount error").also {
                outPutter.print(it.message)
            }
        }

        if (value < minAmount) {
            return Result.Invalid(message = "Min amount error").also {
                outPutter.print(it.message)
            }
        }

        val newBalance = account.balance.subtract(value)

        if (newBalance.signum() < 0) {
            return Result.Invalid(message = "Your account balance is insufficient").also {
                outPutter.print(it.message)
            }
        }

        val newAccount = account.withdraw(value)
        withdrawalLimiter.recordWithdrawal(value)
        database.upsertAccount(newAccount)
        return Result.Handled(message = "${newAccount.id} now has ${newAccount.balance}$ ").also {
            outPutter.print(it.message)
        }
    }

    override fun key() = "withdraw"
}