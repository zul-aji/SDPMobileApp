package com.tsu.sdp_mobile_app.data.repository

import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.response.Group
import com.tsu.sdp_mobile_app.data.response.GroupRequest

class GroupRepo(
    private val api: APIRequest
) : BaseRepo(){

    suspend fun getGroups (
    ) = safeApiCall {
        api.getGroups()
    }

    suspend fun getGroup (
        id: String
    ) = safeApiCall {
        api.getGroup(id)
    }

    suspend fun getGroupByName (
        name: String
    ) = safeApiCall {
        api.getGroupByName(name)
    }

    suspend fun createGroup (
        newGroup: GroupRequest
    ) = safeApiCall {
        api.createGroup(newGroup)
    }

    suspend fun updateGroup (
        id: String,
        group: Group
    ) = safeApiCall {
        api.updateGroup(id, group)
    }

    suspend fun deleteGroup (
        id: String
    ) = safeApiCall {
        api.deleteGroup(id)
    }

    suspend fun getDirections(
    ) = safeApiCall {
        api.getDirections()
    }
}