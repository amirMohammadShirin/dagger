package com.sweet.dagger.model

sealed class Result private constructor(val status: Status) {

    class Invalid() : Result(Status.INVALID)

    class Handled() : Result(Status.HANDLED)


}