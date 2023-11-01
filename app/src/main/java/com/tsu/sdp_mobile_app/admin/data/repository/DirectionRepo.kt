package com.tsu.sdp_mobile_app.admin.data.repository

import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.response.Direction

class DirectionRepo(
    private val api: APIRequest
) : BaseRepo(){

    suspend fun getFaculties(
    ) = safeApiCall {
        api.getFaculties()
    }

    suspend fun getDirections(
    ) = safeApiCall {
        api.getDirections()
    }

    suspend fun getDirection(
        id: String
    ) = safeApiCall {
        api.getDirection(id)
    }

    suspend fun createDirection(
        direction: Direction
    ) = safeApiCall {
        api.createDirection(direction)
    }

    suspend fun updateDirection(
        id: String,
        direction: Direction
    ) = safeApiCall {
        api.updateDirection(id, direction)
    }

    suspend fun deleteDirection(
        id: String
    ) = safeApiCall {
        api.deleteDirection(id)
    }

}