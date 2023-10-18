package com.tsu.sdp_mobile_app.regist.ui.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.MainActivity
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.databinding.ActivityForgetBinding
import com.tsu.sdp_mobile_app.databinding.ActivityLoginBinding
import com.tsu.sdp_mobile_app.databinding.ActivityRegisterBinding
import com.tsu.sdp_mobile_app.regist.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNextReg.setOnClickListener {
            val nextPage = Intent(this, MainActivity::class.java)
            startActivity(nextPage)
        }
    }
}