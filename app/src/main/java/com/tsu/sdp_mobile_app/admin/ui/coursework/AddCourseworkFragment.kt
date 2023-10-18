package com.tsu.sdp_mobile_app.admin.ui.coursework

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.databinding.FragmentAddCourseworkBinding

class AddCourseworkFragment : Fragment() {
    private lateinit var binding: FragmentAddCourseworkBinding

    companion object {
        fun newInstance() = AddCourseworkFragment()
    }

    private lateinit var viewModel: AddCourseworkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCourseworkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_coursework_fl, CourseworkFragment())
                commit()
            }
        }
    }

}