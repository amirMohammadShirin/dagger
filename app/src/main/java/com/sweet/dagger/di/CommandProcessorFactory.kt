package com.sweet.dagger.di

import com.sweet.dagger.model.router.CommandProcessor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        LoginModule::class,
        UserCommandsRouter.InstallationModule::class,
        AmountModule::class
    ]
)
interface CommandProcessorFactory {

    fun processor(): CommandProcessor

}