package com.tsu.sdp_mobile_app.teacher.disct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DisciplineTViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Discipline Fragment"
    }
    val text: LiveData<String> = _text
}