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
import com.tsu.sdp_mobile_app.admin.data.response.DirectionRequest
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddEdudirBinding
import io.grpc.internal.LogExceptionRunnable

class AddEdudirFragment : BaseFragment<
        EdudirViewModel, FragmentAddEdudirBinding, DirectionRepo>() {

    private val facsIDList = ArrayList<String>()
    private val facsNameList = ArrayList<String>()
    private var isAllFieldsChecked = false

    override fun getViewModel(): Class<EdudirViewModel> = EdudirViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddEdudirBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = DirectionRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_edudir_fl, EdudirFragment())
                commit()
            }
        }

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

                    val spinValue = binding.edudirFacultySpin
                    val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, facsNameList)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinValue.adapter = adapter
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

        binding.addAddEdudirButton.setOnClickListener {
            val edudirName = binding.addEdudirName.text.toString()
            val facultyID = facsIDList[binding.edudirFacultySpin.selectedItemPosition]
            val newDirection = DirectionRequest(facultyID, edudirName)

            isAllFieldsChecked = checkAllFields()
            if (isAllFieldsChecked) {
                viewModel.createDirection(newDirection)
                viewModel.createDirectionResponse.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Success -> {
                            Toast.makeText(requireContext(), getString(R.string.dir_made_success), Toast.LENGTH_SHORT).show()
                            parentFragmentManager.beginTransaction().apply {
                                replace(R.id.frag_edudir_fl, EdudirFragment())
                                commit()
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
            }
        }
    }

    private fun checkAllFields(): Boolean {
        if (binding.addEdudirName.length() == 0) {
            Toast.makeText(requireContext(), getString(R.string.dir_name_mt), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}