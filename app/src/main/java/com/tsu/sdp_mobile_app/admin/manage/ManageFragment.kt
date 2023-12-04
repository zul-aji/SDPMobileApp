package com.tsu.sdp_mobile_app.admin.manage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tsu.sdp_mobile_app.admin.DisciplineActivity
import com.tsu.sdp_mobile_app.admin.FacultyActivity
import com.tsu.sdp_mobile_app.admin.GroupActivity
import com.tsu.sdp_mobile_app.admin.EdudirActivity
import com.tsu.sdp_mobile_app.admin.RequestActivity
import com.tsu.sdp_mobile_app.admin.ui.startNewActivity
import com.tsu.sdp_mobile_app.databinding.FragmentManageBinding

class ManageFragment : Fragment() {

    private var _binding: FragmentManageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentManageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.facultyButton.setOnClickListener {
            requireActivity().startNewActivity(FacultyActivity::class.java)
        }

        binding.groupsButton.setOnClickListener {
            requireActivity().startNewActivity(GroupActivity::class.java)
        }

        binding.directionButton.setOnClickListener {
            requireActivity().startNewActivity(EdudirActivity::class.java)
        }

        binding.disciplinesButton.setOnClickListener {
            requireActivity().startNewActivity(DisciplineActivity::class.java)
        }

        binding.requestButton.setOnClickListener {
            requireActivity().startNewActivity(RequestActivity::class.java)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}