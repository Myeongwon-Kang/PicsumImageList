package com.kang6264.picsumimagelist.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.disposables.CompositeDisposable

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationProviderModule {
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}