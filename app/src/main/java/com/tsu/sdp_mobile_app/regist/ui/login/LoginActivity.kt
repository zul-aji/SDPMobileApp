package com.tsu.sdp_mobile_app.regist.ui.login
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tsu.sdp_mobile_app.API.Request.LoginRequest
import com.tsu.sdp_mobile_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginbtn.setOnClickListener {
            val username = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            if (username.isEmpty()) {
                val binuser = binding.edtEmail
                binuser.error = "Username required"  // Fixed the error message
                binuser.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {  // Changed to 'password' check
                val binpass = binding.edtPassword
                binpass.error = "Password required"  // Fixed the error message
                binpass.requestFocus()
                return@setOnClickListener
            }

            val body = LoginRequest(username, password)

            viewModel.login(body)  // Pass 'body' as a parameter to the login function
        }
    }
}