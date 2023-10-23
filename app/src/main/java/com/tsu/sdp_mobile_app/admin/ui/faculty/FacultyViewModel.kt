package com.tsu.sdp_mobile_app.admin.ui.faculty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.admin.data.response.FacultyResponse
import kotlinx.coroutines.launch

class FacultyViewModel(
    private val repo: FacultyRepo
) : ViewModel() {
    private val _getFaculties : MutableLiveData<Resource<FacultyResponse>> = MutableLiveData()
    val getFacultiesResponse: LiveData<Resource<FacultyResponse>>
        get() = _getFaculties

    fun getFaculty (
    ) = viewModelScope.launch {
        _getFaculties.value = repo.getFaculties()
    }
}