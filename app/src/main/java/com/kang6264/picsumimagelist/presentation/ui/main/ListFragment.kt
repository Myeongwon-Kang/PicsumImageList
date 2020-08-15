package com.kang6264.picsumimagelist.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kang6264.picsumimagelist.BR
import com.kang6264.picsumimagelist.R
import com.kang6264.picsumimagelist.databinding.FragmentListBinding
import com.kang6264.picsumimagelist.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>() {

    override val layoutId: Int = R.layout.fragment_list
    override val viewModel: ListViewModel by viewModels()
    override val bindingVariable: Int = BR.viewModel

    lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding()

        viewModel.getImageList()
        viewModel.photoList.observe(viewLifecycleOwner, Observer {
            val test = ""
        })
    }
}