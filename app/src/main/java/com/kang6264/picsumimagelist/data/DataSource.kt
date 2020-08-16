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
        Log.d("순서 =", "loadInitial : init")
        disposable.add(
            remoteService.getImageList(1)
                .subscribe({
                    Log.d("순서 = ", "loadInitial : not empty()");
                    callback.onResult(it, 1, 2)
                }, {
                    Log.d("순서 = ", "loadInitial : empty()");
                    callback.onResult(emptyList(), null, null)
                })
        )
        Log.d("순서 =", "loadInitial : end")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Picsum>) {
        Log.d("순서 =", "loadAfter : init")
        disposable.add(
            remoteService.getImageList(params.key)
                .subscribe({
                    Log.d("순서 = ", "loadAfter : not empty()");
                    callback.onResult(it, params.key.plus(1))
                }, {
                    Log.d("순서 = ", "loadAfter : empty()");
                    callback.onResult(emptyList(), null)
                })
        )
        Log.d("순서 =", "loadAfter : end")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Picsum>) {

    }

}