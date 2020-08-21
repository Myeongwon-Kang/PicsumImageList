package com.kang6264.picsumimagelist.presentation.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.kang6264.picsumimagelist.data.repository.RemoteRepository
import com.kang6264.picsumimagelist.data.response.Picsum
import com.kang6264.picsumimagelist.presentation.base.BaseViewModel
import com.kang6264.picsumimagelist.presentation.utils.rx.SchedulerProvider

class ListViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel() {

    private val _photoList: MutableLiveData<PagedList<Picsum>> = MutableLiveData()
    val photoList : LiveData<PagedList<Picsum>> = _photoList

    fun getImageList() {
        addDisposable(
            remoteRepository.getImageList()
                .observeOn(schedulerProvider.ui())
                .subscribe {
                    _photoList.postValue(it)
                }
        )
    }
}