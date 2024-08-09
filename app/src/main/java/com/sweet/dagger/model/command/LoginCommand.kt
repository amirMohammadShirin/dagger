package com.sweet.dagger.model.command

import com.sweet.dagger.database.Database
import com.sweet.dagger.di.UserCommandsRouter
import com.sweet.dagger.model.Account
import com.sweet.dagger.model.Result
import java.util.Optional
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val database: Database,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory,
    private val account: Optional<Account>
) : SingleArgCommand() {

    override fun handleInput(input: String): Result {


        if (account.isPresent) {
            return Result.Handled(message = "A user is already logged in")
        }

        val account = database.getAccount(input)
        account?.let { nonNullAccount ->
            val message = "$input is logged in with balance ${nonNullAccount.balance}$ . "
            return Result.Handled(
                userCommandsRouterFactory.create(account).router(),
                message = message
            )
        } ?: run {
            return Result.Invalid()
        }
    }

    override fun key(): String = "login"
}