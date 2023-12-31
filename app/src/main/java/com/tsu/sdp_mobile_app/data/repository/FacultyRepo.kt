package com.tsu.sdp_mobile_app.data.repository

import com.tsu.sdp_mobile_app.data.network.APIRequest

class FacultyRepo(
    private val api: APIRequest
) : BaseRepo(){

    suspend fun getFaculties(
    ) = safeApiCall {
        api.getFaculties()
    }

    suspend fun getFaculty(
        id: String
    ) = safeApiCall {
        api.getFaculty(id)
    }

    suspend fun createFaculty(
        name: String
    ) = safeApiCall {
        api.createFaculty(name)
    }

    suspend fun updateFaculty(
        id: String,
        name: String
    ) = safeApiCall {
        api.updateFaculty(id, name)
    }

    suspend fun deleteFaculty(
        id: String
    ) = safeApiCall {
        api.deleteFaculty(id)
    }
}