package com.sweet.dagger.model

import com.sweet.dagger.extension.split
import javax.inject.Inject


class CommandRouter @Inject constructor() {

    private val commands: Map<String, Command> = mapOf()

    fun route(input: String): Result {
        val spiltInput = input.split()
        if (spiltInput.isEmpty()) return invalidCommand(input)

        val commandKey = spiltInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val args = spiltInput.subList(1, spiltInput.size)
        val result = command.handleInput(args)
        println("ATM Response : Loading \"$input\" command ...")
        return if (result.status == Status.INVALID) invalidCommand(input) else result

    }

    private fun invalidCommand(input: String): Result {
        println("ATM Response : Could not understand \"$input\". Please try again.")
        return Result.Invalid()
    }

}