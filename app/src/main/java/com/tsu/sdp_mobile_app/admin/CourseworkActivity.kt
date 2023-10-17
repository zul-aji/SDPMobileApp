package com.tsu.sdp_mobile_app.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.coursework.CourseworkFragment
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyFragment
import com.tsu.sdp_mobile_app.databinding.ActivityCourseworkBinding
import com.tsu.sdp_mobile_app.databinding.ActivityFacultyBinding

class CourseworkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCourseworkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseworkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_coursework_fl, CourseworkFragment())
            commit()
        }
    }
}