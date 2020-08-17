package com.kang6264.picsumimagelist.data.remote

import com.kang6264.picsumimagelist.data.response.Picsum
import io.reactivex.Single

interface RemoteService {
    fun getImageList(page: Int, limit: Int) : Single<List<Picsum>>
}