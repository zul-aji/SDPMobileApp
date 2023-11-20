package com.tsu.sdp_mobile_app.admin.ui.group

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsu.sdp_mobile_app.data.network.Resource
import com.tsu.sdp_mobile_app.data.repository.GroupRepo
import com.tsu.sdp_mobile_app.data.response.DirectionsResponse
import com.tsu.sdp_mobile_app.data.response.Group
import com.tsu.sdp_mobile_app.data.response.GroupRequest
import com.tsu.sdp_mobile_app.data.response.GroupResponse
import com.tsu.sdp_mobile_app.data.response.GroupsResponse
import kotlinx.coroutines.launch

class GroupViewModel(
    private val repo: GroupRepo
) : ViewModel() {
    private val _getGroups : MutableLiveData<Resource<GroupsResponse>> = MutableLiveData()
    val getGroupsResponse: LiveData<Resource<GroupsResponse>>
        get() = _getGroups

    private val _getGroup : MutableLiveData<Resource<GroupResponse>> = MutableLiveData()
    val getGroupResponse: LiveData<Resource<GroupResponse>>
        get() = _getGroup

    private val _createGroup : MutableLiveData<Resource<GroupResponse>> = MutableLiveData()
    val createGroupResponse: LiveData<Resource<GroupResponse>>
        get() = _createGroup

    private val _getDirections : MutableLiveData<Resource<DirectionsResponse>> = MutableLiveData()
    val getDirectionsResponse: LiveData<Resource<DirectionsResponse>>
        get() = _getDirections

    fun getGroups (
    ) = viewModelScope.launch {
        _getGroups.value = repo.getGroups()
    }

    fun getGroup (
        id: String
    ) = viewModelScope.launch {
        _getGroup.value = repo.getGroup(id)
    }

    fun getGroupByName (
        name: String
    ) = viewModelScope.launch {
        _getGroup.value = repo.getGroupByName(name)
    }

    fun createGroup (
        newGroup: GroupRequest
    ) = viewModelScope.launch {
        _createGroup.value = repo.createGroup(newGroup)
    }

    fun updateGroup (
        id: String,
        group: Group
    ) = viewModelScope.launch {
        _getGroup.value = repo.updateGroup(id, group)
    }

    fun deleteGroup (
        id: String
    ) = viewModelScope.launch {
        _getGroup.value = repo.deleteGroup(id)
    }

    fun getDirections (
    ) = viewModelScope.launch {
        _getDirections.value = repo.getDirections()
    }
}