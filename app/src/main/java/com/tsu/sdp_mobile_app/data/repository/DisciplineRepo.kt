package com.tsu.sdp_mobile_app.data.repository

import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.response.Discipline

class DisciplineRepo(
    private val api: APIRequest
) : BaseRepo(){

    suspend fun getDisciplines(
    ) = safeApiCall {
        api.getDisciplines()
    }

    suspend fun getDiscipline(
        id: String
    ) = safeApiCall {
        api.getDiscipline(id)
    }

    suspend fun createDiscipline(
        discipline: Discipline
    ) = safeApiCall {
        api.createDiscipline(discipline)
    }

    suspend fun updateDiscipline(
        id: String,
        discipline: Discipline
    ) = safeApiCall {
        api.updateDiscipline(id, discipline)
    }

    suspend fun deleteDiscipline(
        id: String
    ) = safeApiCall {
        api.deleteDiscipline(id)
    }

}