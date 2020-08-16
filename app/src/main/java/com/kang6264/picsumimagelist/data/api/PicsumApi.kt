package com.kang6264.picsumimagelist.data.api

import com.kang6264.picsumimagelist.data.response.Picsum
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumApi {
    @GET("/v2/list")
    fun getImageList(
        @Query("page") page: Int
    ): Single<List<Picsum>>
}