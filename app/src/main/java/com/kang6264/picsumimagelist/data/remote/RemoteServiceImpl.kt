package com.kang6264.picsumimagelist.data.remote

import com.kang6264.picsumimagelist.data.api.PicsumApi
import com.kang6264.picsumimagelist.data.response.Picscum
import io.reactivex.Single
import javax.inject.Inject

class RemoteServiceImpl @Inject constructor(
    private val picsumApi: PicsumApi
) : RemoteService {

    override fun getImageList(page: Int): Single<List<Picscum>> {
        return picsumApi.getImageList(page, 25);
    }
}