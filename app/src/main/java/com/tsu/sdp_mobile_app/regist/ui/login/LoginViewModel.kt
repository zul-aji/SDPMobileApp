package com.tsu.sdp_mobile_app.regist.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tsu.sdp_mobile_app.API.ApiConfig
import com.tsu.sdp_mobile_app.API.Request.LoginRequest
import com.tsu.sdp_mobile_app.savePrefToken
import kotlinx.coroutines.launch

class LoginViewModel (
    private val application: Application
) : AndroidViewModel(application) {

    private var _message = ""

    fun getMessage() = _message

    fun login(body: LoginRequest) {
        Log.e("LoginActivity", "Masuk 1",)
        viewModelScope.launch {
            try {
                val response = ApiConfig.getApiService().login(body)
                application.savePrefToken(response.token)
            } catch (e: Exception) {
                _message = e.message.toString()
            }
        }
//        ApiConfig.getApiService().login(body)
//            .enqueue(object: Callback<RegisResponse> {
//                override fun onResponse(
//                    call: Call<RegisResponse>,
//                    response: Response<RegisResponse>
//                ) {
//                    if(response.isSuccessful){
//                        Log.e("LoginActivity", "Masuk 2", )
//                        Toast.makeText(this@LoginActivity, "Login berhasil",
//                            Toast.LENGTH_SHORT).show()
//
//                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                        startActivity(intent)
//                        finish()
//                    }
//                }
//
//                override fun onFailure(call: Call<RegisResponse>, t: Throwable) {
//                    Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_LONG).show()
//                }
//            })
    }

}