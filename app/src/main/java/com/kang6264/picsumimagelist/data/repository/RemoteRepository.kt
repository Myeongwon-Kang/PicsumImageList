package com.kang6264.picsumimagelist.data.repository

import androidx.paging.PagedList
import com.kang6264.picsumimagelist.data.response.Picscum
import io.reactivex.Observable

interface RemoteRepository {
    fun getImages() : Observable<PagedList<Picscum>>
}