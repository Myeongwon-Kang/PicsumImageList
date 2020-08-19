package com.kang6264.picsumimagelist.presentation.di

import com.kang6264.picsumimagelist.data.repository.RemoteRepository
import com.kang6264.picsumimagelist.data.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RemoteRepositoryModule{

    @Binds
    @Singleton
    abstract fun bindRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl) : RemoteRepository
}