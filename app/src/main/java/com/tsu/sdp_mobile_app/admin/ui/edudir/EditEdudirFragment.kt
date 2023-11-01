package com.tsu.sdp_mobile_app.admin.ui.edudir

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.DirectionRepo
import com.tsu.sdp_mobile_app.admin.data.response.Faculty
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyAdapter
import com.tsu.sdp_mobile_app.databinding.FragmentEditEdudirBinding

class EditEdudirFragment(dirId: String, facId: String) : BaseFragment<
        EdudirViewModel, FragmentEditEdudirBinding, DirectionRepo>(){

    private val facsIDList = ArrayList<String>()
    private val facsNameList = ArrayList<String>()
    private var dirID = dirId
    private var currFacID = facId
    override fun getViewModel(): Class<EdudirViewModel> = EdudirViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEditEdudirBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = DirectionRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_edudir_fl, EdudirFragment())
                commit()
            }
        }

        var currIndex = 0

        viewModel.getFaculties()
        viewModel.getFacultiesResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    val faculties = it.value.result.faculties
                    faculties.forEachIndexed { _, facItem ->
                        val facultyID = facItem.faculty_id
                        val facultyName = facItem.faculty_name
                        facsIDList.add(facultyID)
                        facsNameList.add(facultyName)
                    }
                    for ((index, facultyId) in facsIDList.withIndex()) {
                        if (facultyId == currFacID) {
                            currIndex = index
                            break
                        }
                    }
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



        viewModel.getDirection(dirID)
        viewModel.getDirectionResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    binding.editEditEdudirName.setText(it.value.result.direction.direction_name)
                    val spinValue = binding.editProgFacultySpin
                    val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, facsNameList)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinValue.adapter = adapter
                    spinValue.setSelection(currIndex)
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