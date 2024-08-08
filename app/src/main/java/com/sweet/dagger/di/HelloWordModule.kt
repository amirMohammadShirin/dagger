package com.sweet.dagger.di

import com.sweet.dagger.model.Command
import com.sweet.dagger.model.command.HelloWorldCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class HelloWordModule {

    @Binds
    @IntoMap
    @StringKey("hello")
    abstract fun bindHelloWorldCommand(helloWorldCommand: HelloWorldCommand) : Command

}