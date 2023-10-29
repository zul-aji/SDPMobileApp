package com.tsu.sdp_mobile_app.API.Request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("username")
    val username: String,

    @SerializedName("birthdate")
    val birthDate: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("avatar")
    val avatar: String,

    @SerializedName("is_student")
    val isStudent: Boolean,

    @SerializedName("faculty_id")
    val facultyId: String,

    @SerializedName("direction_id")
    val directionId: String,

    @SerializedName("group_id")
    val groupId: String,

    @SerializedName("grade_id")
    val gradeId: String,
)