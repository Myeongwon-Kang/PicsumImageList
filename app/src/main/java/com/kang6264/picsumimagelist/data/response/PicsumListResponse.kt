package com.kang6264.picsumimagelist.data.response

/*
data class PicsumListResponse(val picsums : List<Picscum> )

*/

data class Picscum(val id : String, val author : String,
                   val width : Int, val height : Int,
                   val url : String, val download_url : String)
