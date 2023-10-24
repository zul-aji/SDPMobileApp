package com.tsu.sdp_mobile_app.admin.data.response

data class FacultiesResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?,
    val result: FacsResult
)

data class FacsResult(
    val faculties: List<Faculty>
)

data class FacultyResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?,
    val result: FacResult
)

data class FacResult(
    val faculty: Faculty
)

data class Faculty(
    val faculty_id: String,
    val faculty_name: String
)
