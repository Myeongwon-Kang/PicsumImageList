package com.kang6264.picsumimagelist.data

import androidx.paging.DataSource
import com.kang6264.picsumimagelist.data.remote.RemoteService
import com.kang6264.picsumimagelist.data.response.Picscum
import io.reactivex.disposables.CompositeDisposable

class DataSourceFactory(
    private val remoteService: RemoteService,
    private val disposable: CompositeDisposable
) : DataSource.Factory<Int, Picscum>() {
    override fun create(): DataSource<Int, Picscum> {
        return DataSource(remoteService, disposable)
    }
}