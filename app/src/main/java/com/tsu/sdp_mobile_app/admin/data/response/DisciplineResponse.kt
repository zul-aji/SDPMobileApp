package com.tsu.sdp_mobile_app.admin.data.response

data class DisciplineResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?, // Assuming errorMessages can be a list of strings
    val result: DisResult
)

data class DisResult(
    val disciplines: List<Discipline>
)

data class Discipline(
    val discipline_id: String,
    val discipline_name: String,
    val description: String,
    val literature: String,
    val year: Int,
    val grade_id: String,
    val is_online: Boolean,
    val building: String?, // Assuming building and room can be nullable
    val room: String?
)

