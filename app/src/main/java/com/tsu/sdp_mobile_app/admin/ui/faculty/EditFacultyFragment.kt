package com.tsu.sdp_mobile_app.admin.ui.faculty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.admin.data.response.Faculty
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentEditFacultyBinding

class EditFacultyFragment(facultyId: String) : BaseFragment<
        FacultyViewModel, FragmentEditFacultyBinding, FacultyRepo>()
{
    private var facID = facultyId
    override fun getViewModel() = FacultyViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEditFacultyBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = FacultyRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_faculty_fl, FacultyFragment())
                commit()
            }
        }

        viewModel.getFaculty(facID)
        viewModel.getFacultyResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    binding.editEditFacName.setText(it.value.result.faculty.faculty_name)
                }
                is Resource.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        if (it.isNetworkError){ "Network Error" }
                        else { "Fail: ${it.errorMessage.toString()}" },
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    Toast.makeText(
                        requireContext(),
                        "unknown error",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}