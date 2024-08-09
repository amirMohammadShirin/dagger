package com.sweet.dagger.model.command

import com.sweet.dagger.database.Database
import com.sweet.dagger.model.Account
import com.sweet.dagger.model.Command
import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val outPutter: OutPutter,
    private val database: Database,
    private val account: Account
) : Command {
    override fun key(): String = "deposit"

    override fun handleInput(input: List<String>): Result {

        if (input.size != 2)
            return Result.Invalid()

        val newAccount = account.deposit(BigDecimal(input[1]))
        database.upsertAccount(newAccount)
        outPutter.print("${newAccount.id} now has ${newAccount.balance}$ ")
        return Result.Handled()


    }
}