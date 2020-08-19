package com.kang6264.picsumimagelist.data

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.kang6264.picsumimagelist.data.remote.RemoteService
import com.kang6264.picsumimagelist.data.response.Picsum
import io.reactivex.disposables.CompositeDisposable

class DataSource(
    private val remoteService: RemoteService,
    private val disposable: CompositeDisposable
) : PageKeyedDataSource<Int, Picsum>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Picsum>
    ) {
        disposable.add(
            remoteService.getImageList(1, params.requestedLoadSize)
                .subscribe({
                    callback.onResult(it, 1, 2)
                }, {
                    callback.onResult(emptyList(), null, null)
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Picsum>) {
        disposable.add(
            remoteService.getImageList(params.key, params.requestedLoadSize)
                .subscribe({
                    callback.onResult(it, params.key.plus(1))
                }, {
                    callback.onResult(emptyList(), null)
                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Picsum>) {

    }

}