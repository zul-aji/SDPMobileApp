package com.tsu.sdp_mobile_app.admin.data.response

data class DirectionResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?, // Assuming errorMessages can be a list of strings
    val result: DirResult
)

data class DirResult(
    val directions: List<Direction>
)

data class Direction(
    val direction_id: String,
    val faculty_id: String,
    val direction_name: String
)

