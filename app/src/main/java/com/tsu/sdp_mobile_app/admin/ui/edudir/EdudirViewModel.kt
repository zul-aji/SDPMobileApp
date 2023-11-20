package com.tsu.sdp_mobile_app.admin.ui.edudir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsu.sdp_mobile_app.data.network.Resource
import com.tsu.sdp_mobile_app.data.repository.DirectionRepo
import com.tsu.sdp_mobile_app.data.response.Direction
import com.tsu.sdp_mobile_app.data.response.DirectionRequest
import com.tsu.sdp_mobile_app.data.response.DirectionResponse
import com.tsu.sdp_mobile_app.data.response.DirectionsResponse
import com.tsu.sdp_mobile_app.data.response.FacultiesResponse
import kotlinx.coroutines.launch

class EdudirViewModel(
    private val repo: DirectionRepo
) : ViewModel() {
    private val _getDirections : MutableLiveData<Resource<DirectionsResponse>> = MutableLiveData()
    val getDirectionsResponse: LiveData<Resource<DirectionsResponse>>
        get() = _getDirections

    private val _getDirection : MutableLiveData<Resource<DirectionResponse>> = MutableLiveData()
    val getDirectionResponse: LiveData<Resource<DirectionResponse>>
        get() = _getDirection

    private val _createDirection : MutableLiveData<Resource<DirectionResponse>> = MutableLiveData()
    val createDirectionResponse: LiveData<Resource<DirectionResponse>>
        get() = _createDirection

    private val _getFaculties : MutableLiveData<Resource<FacultiesResponse>> = MutableLiveData()
    val getFacultiesResponse: LiveData<Resource<FacultiesResponse>>
        get() = _getFaculties

    fun getDirections (
    ) = viewModelScope.launch {
        _getDirections.value = repo.getDirections()
    }

    fun getDirection (
        id: String
    ) = viewModelScope.launch {
        _getDirection.value = repo.getDirection(id)
    }

    fun createDirection (
        newDirection : DirectionRequest
    ) = viewModelScope.launch {
        _createDirection.value = repo.createDirection(newDirection)
    }

    fun updateDirection (
        id: String,
        direction: Direction
    ) = viewModelScope.launch {
        _getDirection.value = repo.updateDirection(id, direction)
    }

    fun deleteDirection (
        id: String
    ) = viewModelScope.launch {
        _getDirection.value = repo.deleteDirection(id)
    }

    fun getFaculties (
    ) = viewModelScope.launch {
        _getFaculties.value = repo.getFaculties()
    }
}