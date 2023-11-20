package com.tsu.sdp_mobile_app.admin.ui.discipline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsu.sdp_mobile_app.data.network.Resource
import com.tsu.sdp_mobile_app.data.repository.DisciplineRepo
import com.tsu.sdp_mobile_app.data.response.Discipline
import com.tsu.sdp_mobile_app.data.response.DisciplineResponse
import com.tsu.sdp_mobile_app.data.response.DisciplinesResponse
import kotlinx.coroutines.launch

class DisciplineViewModel(
    private val repo: DisciplineRepo
) : ViewModel() {
    private val _getDisciplines : MutableLiveData<Resource<DisciplinesResponse>> = MutableLiveData()
    val getDisciplinesResponse: LiveData<Resource<DisciplinesResponse>>
        get() = _getDisciplines

    private val _getDiscipline : MutableLiveData<Resource<DisciplineResponse>> = MutableLiveData()
    val getDisciplineResponse: LiveData<Resource<DisciplineResponse>>
        get() = _getDiscipline

    fun getDisciplines (
    ) = viewModelScope.launch {
        _getDisciplines.value = repo.getDisciplines()
    }

    fun getDiscipline (
        id: String
    ) = viewModelScope.launch {
        _getDiscipline.value = repo.getDiscipline(id)
    }

    fun createDiscipline (
        discipline: Discipline
    ) = viewModelScope.launch {
        _getDiscipline.value = repo.createDiscipline(discipline)
    }

    fun updateDiscipline (
        id: String,
        discipline: Discipline
    ) = viewModelScope.launch {
        _getDiscipline.value = repo.updateDiscipline(id, discipline)
    }

    fun deleteDiscipline (
        id: String
    ) = viewModelScope.launch {
        _getDiscipline.value = repo.deleteDiscipline(id)
    }
}