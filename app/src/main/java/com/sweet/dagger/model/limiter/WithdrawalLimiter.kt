package com.sweet.dagger.model.limiter

import com.sweet.dagger.di.PerSession
import java.math.BigDecimal
import javax.inject.Inject

@PerSession
class WithdrawalLimiter @Inject constructor() {
    var remainingWithdrawalLimit: BigDecimal = BigDecimal.ZERO
        private set

    fun recordDeposit(amount: BigDecimal) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.add(amount)
        println("ATM Response : limit = $remainingWithdrawalLimit")
    }

    fun recordWithdrawal(amount: BigDecimal) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount)
        println("ATM Response : limit = $remainingWithdrawalLimit")
    }

}