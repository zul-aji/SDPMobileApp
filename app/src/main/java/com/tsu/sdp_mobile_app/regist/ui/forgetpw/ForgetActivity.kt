package com.tsu.sdp_mobile_app.regist.ui.forgetpw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.MainActivity
import com.tsu.sdp_mobile_app.databinding.ActivityForgetBinding
import com.tsu.sdp_mobile_app.databinding.ActivityLoginBinding
import com.tsu.sdp_mobile_app.regist.ui.login.LoginActivity

class ForgetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendPassword.setOnClickListener {
            val nextPage = Intent(this, LoginActivity::class.java)
            startActivity(nextPage)
        }
    }
}