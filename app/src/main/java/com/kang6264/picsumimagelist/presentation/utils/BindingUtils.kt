package com.kang6264.picsumimagelist.presentation.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setThumbnail(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}