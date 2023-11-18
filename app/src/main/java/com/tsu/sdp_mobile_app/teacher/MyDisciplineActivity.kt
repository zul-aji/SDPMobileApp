package com.tsu.sdp_mobile_app.teacher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.teacher.ui.MyDisciplineFragment

class MyDisciplineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_discipline)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyDisciplineFragment.newInstance())
                .commitNow()
        }
    }
}