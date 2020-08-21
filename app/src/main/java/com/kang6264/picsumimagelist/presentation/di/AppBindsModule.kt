package com.kang6264.picsumimagelist.presentation.di

import com.kang6264.picsumimagelist.presentation.utils.rx.AppSchedulerProvider
import com.kang6264.picsumimagelist.presentation.utils.rx.SchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppBindsModule {

    @Binds
    @Singleton
    abstract fun bindSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): SchedulerProvider
}