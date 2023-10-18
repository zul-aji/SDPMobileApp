package com.tsu.sdp_mobile_app.admin.ui.group

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.programme.ProgrammeFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddGroupBinding
import com.tsu.sdp_mobile_app.databinding.FragmentAddProgrammeBinding

class AddGroupFragment : Fragment() {
    private lateinit var binding: FragmentAddGroupBinding

    companion object {
        fun newInstance() = AddGroupFragment()
    }

    private lateinit var viewModel: AddGroupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddGroupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_group_fl, GroupFragment())
                commit()
            }
        }
    }

}