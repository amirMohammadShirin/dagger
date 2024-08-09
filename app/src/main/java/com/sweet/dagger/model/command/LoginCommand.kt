package com.sweet.dagger.model.command

import com.sweet.dagger.database.Database
import com.sweet.dagger.di.UserCommandsRouter
import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val outPutter: OutPutter,
    private val database: Database,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory
) : SingleArgCommand() {

    override fun handleInput(input: String): Result {
        val account = database.getAccount(input)
        account?.let { nonNullAccount ->
            outPutter.print("$input is logged in with balance ${nonNullAccount.balance}$ . ")
            return Result.Handled(
                userCommandsRouterFactory.create(account).router()
            )
        } ?: run {
            return Result.Invalid()
        }
    }

    override fun key(): String = "login"
}