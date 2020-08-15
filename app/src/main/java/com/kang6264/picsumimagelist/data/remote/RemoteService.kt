package com.kang6264.picsumimagelist.data.remote

import com.kang6264.picsumimagelist.data.response.Picscum
import io.reactivex.Single

interface RemoteService {
    fun getImageList(page: Int) : Single<List<Picscum>>
}