package com.tsu.sdp_mobile_app.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.discipline.DisciplineFragment
import com.tsu.sdp_mobile_app.databinding.ActivityDisciplineBinding

class DisciplineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisciplineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisciplineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_discipline_fl, DisciplineFragment())
            commit()
        }
    }
}