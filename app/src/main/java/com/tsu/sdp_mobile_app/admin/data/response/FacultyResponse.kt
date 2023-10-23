package com.tsu.sdp_mobile_app.admin.data.response

data class FacultyResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?, // Use a more specific type if necessary
    val result: FacResult
)

data class FacResult(
    val faculties: List<Faculty>
)

data class Faculty(
    val faculty_id: String,
    val faculty_name: String
)
