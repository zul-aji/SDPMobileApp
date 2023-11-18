package com.tsu.sdp_mobile_app.admin.autumn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AutumnViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is autumn Fragment"
    }
    val text: LiveData<String> = _text
}