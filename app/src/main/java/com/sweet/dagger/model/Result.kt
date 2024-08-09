package com.sweet.dagger.model

import com.sweet.dagger.model.router.CommandRouter

sealed class Result private constructor(
    val status: Status,
    val nestedCommandRouter: CommandRouter? = null,
) {

    class Invalid(nestedCommandRouter: CommandRouter? = null) :
        Result(Status.INVALID, nestedCommandRouter)

    class Handled(nestedCommandRouter: CommandRouter? = null) :
        Result(Status.HANDLED, nestedCommandRouter)

    class Completed(nestedCommandRouter: CommandRouter? = null) :
        Result(Status.COMPLETED, nestedCommandRouter)


}