package com.tsu.sdp_mobile_app.admin.ui.programme

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.faculty.AddFacultyFragment
import com.tsu.sdp_mobile_app.databinding.FragmentProgrammeBinding

class ProgrammeFragment : Fragment() {
    private lateinit var binding: FragmentProgrammeBinding

    companion object {
        fun newInstance() = ProgrammeFragment()
    }

    private lateinit var viewModel: ProgrammeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ProgrammeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProgrammeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addProgram.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_prog_fl, AddProgrammeFragment())
                commit()
            }
        }
    }

}