package com.tsu.sdp_mobile_app.API.Response

import com.google.gson.annotations.SerializedName

data class RegisResponse(
    @field:SerializedName("token")
    val token: String,
)