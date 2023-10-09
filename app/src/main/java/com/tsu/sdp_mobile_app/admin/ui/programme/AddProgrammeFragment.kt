package com.tsu.sdp_mobile_app.admin.ui.programme

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.databinding.FragmentAddProgrammeBinding
import com.tsu.sdp_mobile_app.databinding.FragmentProgrammeBinding

class AddProgrammeFragment : Fragment() {
    private lateinit var binding: FragmentAddProgrammeBinding

    companion object {
        fun newInstance() = AddProgrammeFragment()
    }

    private lateinit var viewModel: AddProgrammeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProgrammeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_prog_fl, ProgrammeFragment())
                commit()
            }
        }
    }

}