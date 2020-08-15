package com.kang6264.picsumimagelist.presentation.di

import com.kang6264.picsumimagelist.data.repository.RemoteRepository
import com.kang6264.picsumimagelist.data.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RemoteRepositoryModule{

    /*@Provides
    fun provideRemoteRepository(remoteService: RemoteService) : RemoteRepository{
        return RemoteRepositoryImpl(remoteService)
    }*/

    @Binds
    abstract fun bindRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl) : RemoteRepository
}