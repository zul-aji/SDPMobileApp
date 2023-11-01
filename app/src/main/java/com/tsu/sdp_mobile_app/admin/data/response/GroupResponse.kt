package com.tsu.sdp_mobile_app.admin.data.response

data class GroupsResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?, // Assuming errorMessages can be a list of strings
    val result: GroupsResult
)

data class GroupsResult(
    val groups: List<Group>
)

data class GroupResponse(
    val statusCode: Int,
    val isSuccess: Boolean,
    val errorMessages: List<String>?, // Assuming errorMessages can be a list of strings
    val result: GroupResult
)

data class GroupResult(
    val group: Group
)

data class Group(
    val group_id: String,
    val direction_id: String,
    val group_name: String
)

data class GroupRequest(
    val direction_id: String,
    val group_name: String
)
