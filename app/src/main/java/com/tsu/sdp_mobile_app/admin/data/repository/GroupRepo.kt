package com.tsu.sdp_mobile_app.admin.data.repository

import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.response.Group

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
        group: Group
    ) = safeApiCall {
        api.createGroup(group)
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
}