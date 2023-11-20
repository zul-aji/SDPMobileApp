package com.tsu.sdp_mobile_app.teacher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.databinding.ActivityDisciplineTBinding

class DisciplineTActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisciplineTBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_discipline_t_fl, DisciplineTFragment())
            commit()
        }
    }
}