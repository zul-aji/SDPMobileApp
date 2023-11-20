package com.tsu.sdp_mobile_app.admin.ui.faculty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsu.sdp_mobile_app.data.network.Resource
import com.tsu.sdp_mobile_app.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.data.response.FacultiesResponse
import com.tsu.sdp_mobile_app.data.response.Faculty
import com.tsu.sdp_mobile_app.data.response.FacultyResponse
import kotlinx.coroutines.launch

class FacultyViewModel(
    private val repo: FacultyRepo
) : ViewModel() {
    private val _getFaculties : MutableLiveData<Resource<FacultiesResponse>> = MutableLiveData()
    val getFacultiesResponse: LiveData<Resource<FacultiesResponse>>
        get() = _getFaculties

    private val _getFaculty : MutableLiveData<Resource<FacultyResponse>> = MutableLiveData()
    val getFacultyResponse: LiveData<Resource<FacultyResponse>>
        get() = _getFaculty

    fun getFaculties (
    ) = viewModelScope.launch {
        _getFaculties.value = repo.getFaculties()
    }

    fun getFaculty (
        id: String
    ) = viewModelScope.launch {
        _getFaculty.value = repo.getFaculty(id)
    }

    fun createFaculty (
        name: String
    ) = viewModelScope.launch {
        _getFaculty.value = repo.createFaculty(name)
    }

    fun updateFaculty (
        id: String,
        name: String
    ) = viewModelScope.launch {
        _getFaculty.value = repo.updateFaculty(id, name)
    }

    fun deleteFaculty (
        id: String
    ) = viewModelScope.launch {
        _getFaculty.value = repo.deleteFaculty(id)
    }
}