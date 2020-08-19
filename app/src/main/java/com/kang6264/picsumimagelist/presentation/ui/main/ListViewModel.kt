package com.kang6264.picsumimagelist.presentation.ui.main

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.paging.PagedList
import com.kang6264.picsumimagelist.data.repository.RemoteRepository
import com.kang6264.picsumimagelist.data.response.Picsum
import com.kang6264.picsumimagelist.presentation.base.BaseViewModel
import com.kang6264.picsumimagelist.presentation.utils.rx.SchedulerProvider

class ListViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel() {
    // 캡술화를 할까?
    val photoList: MutableLiveData<PagedList<Picsum>> = MutableLiveData()

    fun getImageList() {
        addDisposable(
            remoteRepository.getImages()
                .observeOn(schedulerProvider.ui())
                .subscribe {
                    photoList.postValue(it)
                }
        )
    }
}