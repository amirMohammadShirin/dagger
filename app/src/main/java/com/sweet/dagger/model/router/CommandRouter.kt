package com.sweet.dagger.model.router

import com.sweet.dagger.extension.split
import com.sweet.dagger.model.Result
import com.sweet.dagger.model.Status
import com.sweet.dagger.model.command.Command
import javax.inject.Inject


class CommandRouter @Inject constructor(
    private val commands: MutableMap<String, Command>
) {

    fun route(input: String): Result {
        val spiltInput = input.split()
        if (spiltInput.isEmpty()) return invalidCommand(input)

        val commandKey = spiltInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val args = spiltInput.subList(1, spiltInput.size)
        val result = command.handleInput(args)
        return if (result.status == Status.INVALID && result.message.isEmpty()) invalidCommand(input)
        else result

    }

    private fun invalidCommand(input: String): Result {
        return Result.Invalid(message = "Could not understand \"$input\". Please try again.")
    }

}