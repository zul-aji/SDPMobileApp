package com.tsu.sdp_mobile_app.admin.manage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ManageViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is manage Fragment"
    }
    val text: LiveData<String> = _text
}