package com.sweet.dagger.model.command

import com.sweet.dagger.database.Database
import com.sweet.dagger.model.Account
import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import com.sweet.dagger.model.limiter.WithdrawalLimiter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val outPutter: OutPutter,
    private val database: Database,
    private val account: Account,
    private val withdrawalLimiter: WithdrawalLimiter
) : Command {
    override fun key(): String = "deposit"

    override fun handleInput(input: List<String>): Result {

        if (input.size != 1)
            return Result.Invalid()

        val newAccount = account.deposit(BigDecimal(input[0]))
        database.upsertAccount(newAccount)
        withdrawalLimiter.recordDeposit(BigDecimal(input[0]))
        val message = "${newAccount.id} now has ${newAccount.balance}$ "
        outPutter.print(message)
        return Result.Handled(message = message)


    }
}