package com.sweet.dagger.model.command

import com.sweet.dagger.database.Database
import com.sweet.dagger.di.MaxAmount
import com.sweet.dagger.di.MinAmount
import com.sweet.dagger.model.Account
import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(
    private val outPutter: OutPutter,
    private val account: Account,
    private val database: Database,
    @MinAmount
    private val minAmount: BigDecimal,
    @MaxAmount
    private val maxAmount: BigDecimal
) : BigDecimalCommand() {

    override fun handleAmount(value: BigDecimal): Result {

        if (value > maxAmount) {
            outPutter.print("Max amount error")
            return Result.Invalid()
        }

        if (value < minAmount) {
            outPutter.print("Min amount error")
            return Result.Invalid()
        }

        val newBalance = account.balance.subtract(value)

        if (newBalance.signum() < 0) {
            outPutter.print("Your account balance is insufficient")
            return Result.Invalid()
        }

        val newAccount = account.withdraw(value)
        outPutter.print("${newAccount.id} now has ${newAccount.balance}$ ")
        database.upsertAccount(newAccount)
        return Result.Handled()
    }

    override fun key() = "withdraw"
}