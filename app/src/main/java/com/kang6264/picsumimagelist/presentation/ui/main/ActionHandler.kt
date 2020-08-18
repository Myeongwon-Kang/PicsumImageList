package com.kang6264.picsumimagelist.presentation.ui.main

import com.kang6264.picsumimagelist.data.response.Picsum

interface ActionHandler {
    fun openDetail(picsum: Picsum)
}