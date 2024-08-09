package com.sweet.dagger.model.command

import com.sweet.dagger.model.Account
import com.sweet.dagger.model.Result
import java.util.Optional
import javax.inject.Inject

class LogoutCommand @Inject constructor(
    private val account: Optional<Account>,
) : Command {

    override fun key() = "logout"

    override fun handleInput(input: List<String>): Result {
        return try {
            val username = input[0]
            if (username == account.get().id) {
                Result.Completed(message = "User with username \"$username\" logged out.")
            } else {
                Result.Invalid(message = "incorrect username.")
            }
        } catch (e: Exception) {
            Result.Invalid()
        }

    }
}