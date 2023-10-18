package com.tsu.sdp_mobile_app.admin.ui.faculty

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.programme.ProgrammeFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddFacultyBinding
import com.tsu.sdp_mobile_app.databinding.FragmentAddProgrammeBinding

class AddFacultyFragment : Fragment() {
    private lateinit var binding: FragmentAddFacultyBinding

    companion object {
        fun newInstance() = AddFacultyFragment()
    }

    private lateinit var viewModel: AddFacultyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddFacultyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_faculty_fl, FacultyFragment())
                commit()
            }
        }
    }

}