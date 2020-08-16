package com.kang6264.picsumimagelist.data.response

/*
data class PicsumListResponse(val picsums : List<Picscum> )

*/

data class Picsum(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)