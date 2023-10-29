package com.tsu.sdp_mobile_app.API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object ApiConfig {
    private val okhttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            logger.intercept(it)
        }
        .build()

    fun getApiService(): ApiService {
        val retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://sdpt1.kreosoft.space/api/")
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .client(okhttpClient)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}