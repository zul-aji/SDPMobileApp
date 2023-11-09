package com.tsu.sdp_mobile_app.admin.ui.edudir

import android.app.AlertDialog
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
import com.tsu.sdp_mobile_app.admin.data.response.Direction
import com.tsu.sdp_mobile_app.admin.data.response.Faculty
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyAdapter
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyFragment
import com.tsu.sdp_mobile_app.admin.ui.group.GroupFragment
import com.tsu.sdp_mobile_app.databinding.FragmentEditEdudirBinding

class EditEdudirFragment(dirId: String, facId: String) : BaseFragment<
        EdudirViewModel, FragmentEditEdudirBinding, DirectionRepo>(){

    private val facsIDList = ArrayList<String>()
    private val facsNameList = ArrayList<String>()
    private var dirID = dirId
    private var currFacID = facId
    private var isAllFieldsChecked = false
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
        val spinValue = binding.editProgFacultySpin
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, facsNameList)

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

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinValue.adapter = adapter
                    for ((index, facultyId) in facsIDList.withIndex()) {
                        if (facultyId == currFacID) {
                            currIndex = index
                            break
                        }
                    }
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



        viewModel.getDirection(dirID)
        viewModel.getDirectionResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    binding.editEditEdudirName.setText(it.value.result.direction.direction_name)
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

        binding.editProgSaveButton.setOnClickListener {
            val facid = facsIDList[spinValue.selectedItemId.toInt()]
            val dirname = binding.editEditEdudirName.text.toString()
            val dirDet = Direction(dirID, facid, dirname)

            isAllFieldsChecked = checkAllFields()
            if (isAllFieldsChecked) {
                viewModel.updateDirection(dirID, dirDet)
                viewModel.getDirectionResponse.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Success -> {
                            Toast.makeText(requireContext(), getString(R.string.group_up_success), Toast.LENGTH_SHORT).show()
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

        binding.editProgDeleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(context, R.style.CustomAlertDialogTheme)
            builder.setMessage(getString(R.string.delete_dir_dialog))
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->
                    viewModel.deleteDirection(dirID)
                    viewModel.getDirectionResponse.observe(viewLifecycleOwner){
                        when (it) {
                            is Resource.Success -> {
                                Toast.makeText(requireContext(), getString(R.string.dir_del_success), Toast.LENGTH_SHORT).show()
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
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }

    private fun checkAllFields(): Boolean {
        if (binding.editEditEdudirName.length() == 0) {
            Toast.makeText(requireContext(), getString(R.string.dir_name_mt), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}