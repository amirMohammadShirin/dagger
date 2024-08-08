package com.sweet.dagger

data class Result(
    val status: Status
) {

    fun invalid(): Result = this.copy(status = Status.INVALID)

    fun handled(): Result = this.copy(status = Status.HANDLED)

}