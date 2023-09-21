package com.tsu.sdp_mobile_app.ui.spring

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpringViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is spring Fragment"
    }
    val text: LiveData<String> = _text
}