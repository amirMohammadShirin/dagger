package com.sweet.dagger.model.command

import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(
    private val outPutter: OutPutter
) : Command {

    override fun key() = "hello"

    override fun handleInput(input: List<String>): Result {
        return if (input.isEmpty()) Result.Invalid() else {
            val message = "Word"
            Result.Handled(message = message).also {
                outPutter.print(message)
            }
        }
    }
}