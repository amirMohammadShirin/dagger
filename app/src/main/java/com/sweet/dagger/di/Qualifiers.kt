package com.sweet.dagger.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MinAmount {
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MaxAmount {
}
