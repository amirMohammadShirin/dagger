package com.sweet.dagger

interface Command {

    fun key(): String

    fun handleInput(input: List<String>): Result

}