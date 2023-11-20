package com.tsu.sdp_mobile_app.data.response

data class DirectionsResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?, // Assuming errorMessages can be a list of strings
    val result: DirsResult
)

data class DirsResult(
    val directions: List<Direction>
)

data class DirectionResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?, // Assuming errorMessages can be a list of strings
    val result: DirResult
)

data class DirResult(
    val direction: Direction
)

data class Direction(
    val direction_id: String,
    val faculty_id: String,
    val direction_name: String
)

data class DirectionRequest(
    val faculty_id: String,
    val direction_name: String
)
