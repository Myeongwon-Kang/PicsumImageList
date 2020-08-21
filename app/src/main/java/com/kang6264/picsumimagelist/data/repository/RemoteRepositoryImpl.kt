package com.kang6264.picsumimagelist.data.repository

import android.util.Log
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.kang6264.picsumimagelist.data.DataSourceFactory
import com.kang6264.picsumimagelist.data.remote.RemoteService
import com.kang6264.picsumimagelist.data.response.Picsum
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteService: RemoteService,
    private val disposable: CompositeDisposable
) : RemoteRepository {
    override fun getImageList(): Observable<PagedList<Picsum>> {
        val dataSourceFactory = DataSourceFactory(remoteService, disposable)

        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(30)
            .setPrefetchDistance(10)
            .build()

        return RxPagedListBuilder(dataSourceFactory, config).buildObservable()
    }
}