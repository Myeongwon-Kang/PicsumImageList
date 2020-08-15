package com.kang6264.picsumimagelist.data.repository

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.kang6264.picsumimagelist.data.DataSourceFactory
import com.kang6264.picsumimagelist.data.remote.RemoteService
import com.kang6264.picsumimagelist.data.response.Picscum
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteService: RemoteService,
    private val disposable: CompositeDisposable
) : RemoteRepository {
    override fun getImages(): Observable<PagedList<Picscum>> {
        val dataSourceFactory = DataSourceFactory(remoteService, disposable)

        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(40)
            .setEnablePlaceholders(false)
            .build()

        return RxPagedListBuilder(dataSourceFactory, config).buildObservable()
    }
}