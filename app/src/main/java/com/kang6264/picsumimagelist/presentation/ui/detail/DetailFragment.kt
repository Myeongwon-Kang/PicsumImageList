package com.kang6264.picsumimagelist.presentation.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.kang6264.picsumimagelist.BR
import com.kang6264.picsumimagelist.R
import com.kang6264.picsumimagelist.databinding.FragmentDetailBinding
import com.kang6264.picsumimagelist.presentation.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val layoutId: Int = R.layout.fragment_detail
    override val viewModel: DetailViewModel by viewModels()
    override val bindingVariable: Int = BR.viewModel

    private val args: DetailFragmentArgs by navArgs()

    lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding()
        binding.picsum = args.picsum
    }
}