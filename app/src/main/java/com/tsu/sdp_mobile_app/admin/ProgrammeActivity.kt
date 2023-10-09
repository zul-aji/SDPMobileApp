package com.tsu.sdp_mobile_app.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyFragment
import com.tsu.sdp_mobile_app.admin.ui.programme.ProgrammeFragment
import com.tsu.sdp_mobile_app.databinding.ActivityProgrammeBinding

class ProgrammeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProgrammeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgrammeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_prog_fl, ProgrammeFragment())
            commit()
        }
    }
}