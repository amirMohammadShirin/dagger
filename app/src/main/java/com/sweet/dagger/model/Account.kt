package com.sweet.dagger.model

import java.math.BigDecimal

data class Account(
    val id: String,
    val balance: BigDecimal = BigDecimal.ZERO,
) {
    fun deposit(amount: BigDecimal): Account = this.copy(
        balance = balance.add(amount)
    )
}
