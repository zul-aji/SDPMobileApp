package com.tsu.sdp_mobile_app.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyFragment

class FacultyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FacultyFragment.newInstance())
                .commitNow()
        }
    }
}