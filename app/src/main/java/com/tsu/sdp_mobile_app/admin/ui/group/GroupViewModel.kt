package com.tsu.sdp_mobile_app.admin.ui.group

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.GroupRepo
import com.tsu.sdp_mobile_app.admin.data.response.Group
import com.tsu.sdp_mobile_app.admin.data.response.GroupResponse
import com.tsu.sdp_mobile_app.admin.data.response.GroupsResponse
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
        group: Group
    ) = viewModelScope.launch {
        _getGroup.value = repo.createGroup(group)
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
}