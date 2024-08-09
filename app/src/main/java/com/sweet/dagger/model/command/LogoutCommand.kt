package com.sweet.dagger.model.command

import com.sweet.dagger.model.Account
import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import javax.inject.Inject

class LogoutCommand @Inject constructor(
    private val outPutter: OutPutter,
    private val account: Account
) : Command {

    override fun key() = "logout"

    override fun handleInput(input: List<String>): Result {
        return try {
            val username = input[0]
            if (username == account.id) {
                outPutter.print("User with username \"$username\" logged out.")
                Result.Completed()
            } else {
                outPutter.print("incorrect username.")
                Result.Invalid()
            }
        } catch (e: Exception) {
            Result.Invalid()
        }

    }
}