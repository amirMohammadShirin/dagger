package com.sweet.dagger.di

import dagger.Module
import dagger.Provides
import java.math.BigDecimal

@Module
class AmountModule {

    @Provides
    @MinAmount
    fun provideMinAmount() = BigDecimal.ZERO

    @Provides
    @MaxAmount
    fun provideMaxAmount() = BigDecimal(10000)

}