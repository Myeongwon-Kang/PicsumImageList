package com.kang6264.picsumimagelist.presentation.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.kang6264.picsumimagelist.data.api.PicsumApi
import com.kang6264.picsumimagelist.data.remote.RemoteService
import com.kang6264.picsumimagelist.data.repository.RemoteRepository
import com.kang6264.picsumimagelist.data.repository.RemoteRepositoryImpl
import com.kang6264.picsumimagelist.data.response.Picscum
import com.kang6264.picsumimagelist.presentation.base.BaseViewModel

class ListViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository
) : BaseViewModel() {
    // 캡술화를 할까?
    val photoList: MutableLiveData<PagedList<Picscum>> = MutableLiveData()
    /*
    private val remoteRepository : RemoteRepository by lazy {
        RemoteRepositoryImpl(picsumApi, compositeDisposable)
    }*/

    fun getImageList() {
        compositeDisposable.add(
            remoteRepository.getImages()
                .subscribe { it ->
                    run {
                        photoList.postValue(it)
                    }
                }
        )
    }
}