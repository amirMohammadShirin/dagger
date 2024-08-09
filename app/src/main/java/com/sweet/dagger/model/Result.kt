package com.sweet.dagger.model

import com.sweet.dagger.model.router.CommandRouter

sealed class Result private constructor(
    val status: Status,
    val nestedCommandRouter: CommandRouter? = null,
    val message: String = ""
) {

    class Invalid(nestedCommandRouter: CommandRouter? = null, message: String = "") :
        Result(Status.INVALID, nestedCommandRouter, message)

    class Handled(nestedCommandRouter: CommandRouter? = null, message: String = "") :
        Result(Status.HANDLED, nestedCommandRouter, message)

    class Completed(nestedCommandRouter: CommandRouter? = null, message: String = "") :
        Result(Status.COMPLETED, nestedCommandRouter, message)


}