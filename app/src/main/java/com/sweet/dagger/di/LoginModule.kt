package com.sweet.dagger.di

import com.sweet.dagger.model.Command
import com.sweet.dagger.model.command.LoginCommand
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {

    @Binds
    abstract fun bindLoginCommand(loginCommand: LoginCommand):Command

}