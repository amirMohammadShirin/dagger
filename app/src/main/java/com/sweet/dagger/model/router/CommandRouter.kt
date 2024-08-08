package com.sweet.dagger.model.router

import com.sweet.dagger.extension.split
import com.sweet.dagger.model.Command
import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.Result
import com.sweet.dagger.model.Status
import javax.inject.Inject


class CommandRouter @Inject constructor(
    command: Command,
    private val outPutter: OutPutter
) {

    private val commands: MutableMap<String, Command> = mutableMapOf()

    init {
        commands[command.key()] = command
    }

    fun route(input: String): Result {
        val spiltInput = input.split()
        if (spiltInput.isEmpty()) return invalidCommand(input)

        val commandKey = spiltInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val args = spiltInput.subList(1, spiltInput.size)
        val result = command.handleInput(args)
        return if (result.status == Status.INVALID) invalidCommand(input) else result

    }

    private fun invalidCommand(input: String): Result {
        outPutter.print("Could not understand \"$input\". Please try again.")
        return Result.Invalid()
    }

}