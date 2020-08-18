package com.kang6264.picsumimagelist.presentation.ui.main

import android.view.View
import com.kang6264.picsumimagelist.data.response.Picsum

interface ActionHandler {
    fun openDetail(picsum: Picsum, view: View)
}