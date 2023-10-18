package com.tsu.sdp_mobile_app.admin.ui.coursework

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.faculty.AddFacultyFragment
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyViewModel
import com.tsu.sdp_mobile_app.databinding.FragmentCourseworkBinding
import com.tsu.sdp_mobile_app.databinding.FragmentFacultyBinding

class CourseworkFragment : Fragment() {
    private lateinit var binding: FragmentCourseworkBinding

    companion object {
        fun newInstance() = CourseworkFragment()
    }

    private lateinit var viewModel: CourseworkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CourseworkViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCourseworkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addCoursework.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_coursework_fl, AddCourseworkFragment())
                commit()
            }
        }
    }

}