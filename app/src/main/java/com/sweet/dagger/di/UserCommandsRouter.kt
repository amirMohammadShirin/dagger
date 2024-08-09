package com.sweet.dagger.di

import com.sweet.dagger.model.Account
import com.sweet.dagger.model.router.CommandRouter
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(
    modules = [UserCommandModule::class]
)
interface UserCommandsRouter {

    fun router(): CommandRouter

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance account: Account
        ): UserCommandsRouter

    }

    @Module(
        subcomponents = [UserCommandsRouter::class]
    )
    interface InstallationModule {

    }

}