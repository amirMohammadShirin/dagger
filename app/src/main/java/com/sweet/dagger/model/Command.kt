package com.sweet.dagger.model

interface Command {

    fun key(): String

    fun handleInput(input: List<String>): Result

}