package com.kang6264.picsumimagelist.presentation.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.kang6264.picsumimagelist.R
import com.kang6264.picsumimagelist.databinding.ActivityDetailBinding
import com.kang6264.picsumimagelist.BR
import com.kang6264.picsumimagelist.presentation.base.BaseActivity

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val layoutId: Int = R.layout.activity_detail
    override val viewModel: DetailViewModel by viewModels()
    override val bindingVariable: Int = BR.viewModel

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()

        val imageUrl = intent.getStringExtra("image_url")
        viewModel.imageUrl.value = imageUrl
    }
}