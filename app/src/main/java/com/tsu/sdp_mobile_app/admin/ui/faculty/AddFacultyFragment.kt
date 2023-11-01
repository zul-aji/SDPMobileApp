package com.tsu.sdp_mobile_app.admin.ui.faculty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddFacultyBinding

class AddFacultyFragment : BaseFragment<FacultyViewModel,FragmentAddFacultyBinding, FacultyRepo>() {
    override fun getViewModel() = FacultyViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddFacultyBinding.inflate(inflater, container, false)
    override fun getFragmentRepository() = FacultyRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

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