package com.sweet.dagger.model.command

import com.sweet.dagger.model.Result
import java.math.BigDecimal

abstract class BigDecimalCommand : Command {

    override fun handleInput(input: List<String>): Result {
        try {
            if (input.isNotEmpty())
                return handleAmount(BigDecimal(input[1]))
            return Result.Invalid()
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.Invalid()
        }
    }

    abstract fun handleAmount(value: BigDecimal): Result

}