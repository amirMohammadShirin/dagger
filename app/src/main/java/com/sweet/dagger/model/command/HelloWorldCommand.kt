package com.sweet.dagger.model.command

import com.sweet.dagger.model.Command
import com.sweet.dagger.model.Result
import javax.inject.Inject

class HelloWorldCommand @Inject constructor() : Command {

    override fun key() = "hello"

    override fun handleInput(input: List<String>): Result {
        return if (input.isEmpty()) Result.Invalid() else Result.Handled().also {
            println("ATM Response : Word")
        }
    }
}