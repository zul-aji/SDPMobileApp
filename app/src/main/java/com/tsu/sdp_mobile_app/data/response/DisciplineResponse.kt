package com.tsu.sdp_mobile_app.data.response

data class DisciplinesResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?, // Assuming errorMessages can be a list of strings
    val result: DissResult
)

data class DissResult(
    val disciplines: List<Discipline>
)

data class DisciplineResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?,
    val result: DisResult
)

data class DisResult(
    val discipline: Discipline
)

data class Discipline(
    val discipline_id: String,
    val discipline_name: String,
    val description: String,
    val literature: String,
    val year: Int,
    val grade_id: String,
    val is_online: Boolean,
    val building: String?,
    val room: String?
)

