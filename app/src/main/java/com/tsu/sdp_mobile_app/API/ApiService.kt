package com.tsu.sdp_mobile_app.API

import com.tsu.sdp_mobile_app.API.Request.LoginRequest
import com.tsu.sdp_mobile_app.API.Request.RegisterRequest
import com.tsu.sdp_mobile_app.API.Response.RegisResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("account/register")
    suspend fun register(
        @Body body: RegisterRequest
    ): RegisResponse

    @POST("account/login")
    suspend fun login(
        @Body body: LoginRequest
    ): RegisResponse
}