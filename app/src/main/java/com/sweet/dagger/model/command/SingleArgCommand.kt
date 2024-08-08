package com.sweet.dagger.model.command

import com.sweet.dagger.model.Command
import com.sweet.dagger.model.Result

abstract class SingleArgCommand : Command {

    override fun handleInput(input: List<String>): Result {
        return handleInput(input[0])
    }

    abstract fun handleInput(input: String): Result

}