package com.sweet.dagger.di

import com.sweet.dagger.model.CommandRouter
import dagger.Component

@Component(
    modules = [
        LoginModule::class,
        OutPutterModule::class,
    ]
)
interface CommandRouterFactory {

    fun router(): CommandRouter

}