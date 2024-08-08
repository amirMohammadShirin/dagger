package com.sweet.dagger.di

import com.sweet.dagger.model.OutPutter
import com.sweet.dagger.model.outputer.SystemOutPutter
import dagger.Module
import dagger.Provides

@Module
class OutPutterModule {

    @Provides
    fun provideSystemOutPutter(): OutPutter {
        return SystemOutPutter()
    }

}