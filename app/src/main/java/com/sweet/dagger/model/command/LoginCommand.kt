package com.sweet.dagger.model.command

import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val outPutter: OutPutter
) : SingleArgCommand() {

    override fun handleInput(input: String): Result {
        outPutter.print("$input is logged in. ")
        return Result.Handled()
    }

    override fun key(): String = "login"
}