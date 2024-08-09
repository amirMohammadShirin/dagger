package com.sweet.dagger.model.router

import com.sweet.dagger.model.Result
import com.sweet.dagger.model.Status
import java.util.ArrayDeque
import java.util.Deque
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandProcessor @Inject constructor(
    commandsRouter: CommandRouter
) {

    private val commandRouterStack: Deque<CommandRouter> = ArrayDeque()

    init {
        commandRouterStack.push(commandsRouter)
    }

    fun process(input: String): Result {
        val result = commandRouterStack.peek()?.route(input)
        if (result?.status == Status.COMPLETED) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty()) Result.Completed() else Result.Handled()
        }
        result?.nestedCommandRouter?.let {
            commandRouterStack.push(it)
        }
        return result ?: Result.Invalid()
    }

}