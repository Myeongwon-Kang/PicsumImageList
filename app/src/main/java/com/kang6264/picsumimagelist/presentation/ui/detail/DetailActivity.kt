package com.kang6264.picsumimagelist.presentation.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.kang6264.picsumimagelist.R
import com.kang6264.picsumimagelist.databinding.ActivityDetailBinding
import com.kang6264.picsumimagelist.BR
import com.kang6264.picsumimagelist.data.response.Picsum
import com.kang6264.picsumimagelist.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val layoutId: Int = R.layout.activity_detail
    override val viewModel: DetailViewModel by viewModels()
    override val bindingVariable: Int = BR.viewModel

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()

        val picsum = intent.getParcelableExtra<Picsum>("picsum")
        viewModel.imageUrl.value = picsum?.download_url

        toolbar.title = picsum?.author
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}