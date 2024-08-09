package com.sweet.dagger.di

import com.sweet.dagger.model.command.Command
import com.sweet.dagger.model.command.LoginCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @StringKey("login")
    abstract fun bindLoginCommand(loginCommand: LoginCommand): Command

}