package com.sweet.dagger.model

abstract class SingleArgCommand : Command {

    override fun handleInput(input: List<String>): Result {
        return handleInput(input[0])
    }

    abstract fun handleInput(input: String): Result

}