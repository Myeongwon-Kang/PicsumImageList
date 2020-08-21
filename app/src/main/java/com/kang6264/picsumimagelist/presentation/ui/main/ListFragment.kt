package com.kang6264.picsumimagelist.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.kang6264.picsumimagelist.BR
import com.kang6264.picsumimagelist.R
import com.kang6264.picsumimagelist.data.response.Picsum
import com.kang6264.picsumimagelist.databinding.FragmentListBinding
import com.kang6264.picsumimagelist.presentation.base.BaseFragment
import com.kang6264.picsumimagelist.presentation.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>(), ActionHandler {

    override val layoutId: Int = R.layout.fragment_list
    override val viewModel: ListViewModel by viewModels()
    override val bindingVariable: Int = BR.viewModel

    private var adapter = ListMainAdapter(this)

    lateinit var binding: FragmentListBinding

    private val gridLayoutManager by lazy {
        GridLayoutManager(context, 3)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding()

        binding.apply {
            listMain.adapter = adapter
            listMain.layoutManager = gridLayoutManager
        }

        viewModel.photoList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.getImageList()
    }

    override fun openDetail(picsum: Picsum, view: View) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("picsum", picsum)
        startActivity(intent)
    }
}