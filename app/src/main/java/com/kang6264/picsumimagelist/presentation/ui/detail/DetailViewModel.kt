package com.kang6264.picsumimagelist.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import com.kang6264.picsumimagelist.presentation.base.BaseViewModel

class DetailViewModel : BaseViewModel(){
    val imageUrl = MutableLiveData<String>()
}