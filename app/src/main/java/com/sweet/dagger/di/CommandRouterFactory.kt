package com.sweet.dagger.di

import com.sweet.dagger.model.router.CommandRouter
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [
        LoginModule::class,
        OutPutterModule::class,
        HelloWordModule::class,
        UserCommandModule::class
    ]
)
@Singleton
interface CommandRouterFactory {

    fun router(): CommandRouter

}