package com.kang6264.picsumimagelist.data

import androidx.paging.PageKeyedDataSource
import com.kang6264.picsumimagelist.data.remote.RemoteService
import com.kang6264.picsumimagelist.data.response.Picscum
import io.reactivex.disposables.CompositeDisposable

class DataSource(
    private val remoteService: RemoteService,
    private val disposable: CompositeDisposable
) : PageKeyedDataSource<Int, Picscum>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Picscum>
    ) {
        remoteService.getImageList(1)
            .subscribe({
                callback.onResult(it, null, 2)
            }, {
                callback.onResult(emptyList(), null, null)
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Picscum>) {
        remoteService.getImageList(params.key)
            .subscribe({
                callback.onResult(it, params.key.plus(1))
            }, {
                callback.onResult(emptyList(), null)
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Picscum>) {

    }

}