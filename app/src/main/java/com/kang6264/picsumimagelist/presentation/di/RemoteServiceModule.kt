package com.kang6264.picsumimagelist.presentation.di

import com.kang6264.picsumimagelist.data.remote.RemoteService
import com.kang6264.picsumimagelist.data.remote.RemoteServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RemoteServiceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteService(remoteServiceImpl: RemoteServiceImpl): RemoteService
}