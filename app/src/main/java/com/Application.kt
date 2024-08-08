package com

import android.app.Application
import com.sweet.dagger.di.ApplicationComponent
import com.sweet.dagger.di.DaggerApplicationComponent

class Application : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }

}