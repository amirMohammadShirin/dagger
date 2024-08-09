package com.sweet.dagger.di

import com.sweet.dagger.model.command.Command
import com.sweet.dagger.model.command.DepositCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class UserCommandModule {

    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun bindDepositCommand(depositCommand: DepositCommand): Command

}