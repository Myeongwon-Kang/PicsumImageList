package com.kang6264.picsumimagelist.data.remote

import android.util.Log
import com.kang6264.picsumimagelist.data.api.PicsumApi
import com.kang6264.picsumimagelist.data.response.Picsum
import com.kang6264.picsumimagelist.presentation.utils.rx.SchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class RemoteServiceImpl @Inject constructor(
    private val picsumApi: PicsumApi,
    private val schedulerProvider: SchedulerProvider
) : RemoteService {

    override fun getImageList(page: Int, limit: Int): Single<List<Picsum>> {
        return picsumApi.getImageList(page, limit).subscribeOn(schedulerProvider.io())
    }
}