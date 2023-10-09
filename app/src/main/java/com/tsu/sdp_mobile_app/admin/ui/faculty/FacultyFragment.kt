package com.tsu.sdp_mobile_app.admin.ui.faculty

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.GroupActivity
import com.tsu.sdp_mobile_app.databinding.FragmentFacultyBinding

class FacultyFragment : Fragment() {
    private lateinit var binding: FragmentFacultyBinding

    companion object {
        fun newInstance() = FacultyFragment()
    }

    private lateinit var viewModel: FacultyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FacultyViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFacultyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addFaculties.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_faculty_fl, AddFacultyFragment())
                commit()
            }
        }
    }

}