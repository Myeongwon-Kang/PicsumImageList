package com.kang6264.picsumimagelist.presentation.ui.main

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.ViewCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kang6264.picsumimagelist.BR
import com.kang6264.picsumimagelist.R
import com.kang6264.picsumimagelist.data.response.Picsum
import com.kang6264.picsumimagelist.databinding.FragmentListBinding
import com.kang6264.picsumimagelist.presentation.base.BaseFragment
import com.kang6264.picsumimagelist.presentation.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>(), ActionHandler {

    override val layoutId: Int = R.layout.fragment_list
    override val viewModel: ListViewModel by viewModels()
    override val bindingVariable: Int = BR.viewModel

    private var adapter = ListMainAdapter(this)

    lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding()

        binding.listMain.adapter = adapter
        binding.listMain.apply {
            addItemDecoration(DividerItemDecoration(view.context, LinearLayoutManager.VERTICAL))
        }

        viewModel.photoList.observe(viewLifecycleOwner, Observer {
            Log.d("순서 =", "ListFragment() : observe = ${it.size}")
            adapter.submitList(it)
        })

        viewModel.getImageList()
    }

    override fun openDetail(picsum: Picsum, view: View) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("image_url", picsum.download_url)
        startActivity(intent)
    }
}