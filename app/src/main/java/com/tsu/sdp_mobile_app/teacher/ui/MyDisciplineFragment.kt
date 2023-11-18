package com.tsu.sdp_mobile_app.teacher.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tsu.sdp_mobile_app.R

class MyDisciplineFragment : Fragment() {

    companion object {
        fun newInstance() = MyDisciplineFragment()
    }

    private lateinit var viewModel: MyDisciplineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MyDisciplineViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_my_discipline, container, false)
    }

}