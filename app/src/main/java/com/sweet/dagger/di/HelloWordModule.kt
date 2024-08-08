package com.sweet.dagger.di

import com.sweet.dagger.model.Command
import com.sweet.dagger.model.command.HelloWorldCommand
import dagger.Binds
import dagger.Module

@Module
abstract class HelloWordModule {

    @Binds
    abstract fun bindHelloWorldCommand(helloWorldCommand: HelloWorldCommand) : Command

}