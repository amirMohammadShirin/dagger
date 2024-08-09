package com.sweet.dagger.model.command

import com.sweet.dagger.model.Result

interface Command {

    fun key(): String

    fun handleInput(input: List<String>): Result

}