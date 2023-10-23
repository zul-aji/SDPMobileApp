package com.tsu.sdp_mobile_app.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.edudir.EdudirFragment
import com.tsu.sdp_mobile_app.databinding.ActivityEdudirBinding

class EdudirActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEdudirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEdudirBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_edudir_fl, EdudirFragment())
            commit()
        }
    }
}