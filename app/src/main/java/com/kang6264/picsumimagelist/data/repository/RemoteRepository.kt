package com.kang6264.picsumimagelist.data.repository

import androidx.paging.PagedList
import com.kang6264.picsumimagelist.data.response.Picsum
import io.reactivex.Observable

interface RemoteRepository {
    fun getImageList() : Observable<PagedList<Picsum>>
}