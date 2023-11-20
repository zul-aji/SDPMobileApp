package com.tsu.sdp_mobile_app.admin.ui.faculty

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.network.Resource
import com.tsu.sdp_mobile_app.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.data.response.Faculty
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentEditFacultyBinding

class EditFacultyFragment(facultyId: String) : BaseFragment<
        FacultyViewModel, FragmentEditFacultyBinding, FacultyRepo>()
{
    private var isAllFieldsChecked = false
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

        binding.editFacSaveButton.setOnClickListener {
            val facultyName = binding.editEditFacName.text.toString()

            isAllFieldsChecked = checkAllFields()
            if (isAllFieldsChecked){
                viewModel.updateFaculty(facID, facultyName)
                viewModel.getFacultyResponse.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Success -> {
                            Toast.makeText(requireContext(), getString(R.string.fac_up_success), Toast.LENGTH_SHORT).show()
                            parentFragmentManager.beginTransaction().apply {
                                replace(R.id.frag_faculty_fl, FacultyFragment())
                                commit()
                            }
                        }
                        is Resource.Failure -> {
                            it.errorMessage?.let { it1 -> Log.e("error", it1, ) }
                            Toast.makeText(
                                requireContext(),
                                if (it.isNetworkError){ it.errorMessage}
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

        binding.editFacDeleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(context, R.style.CustomAlertDialogTheme)
            builder.setMessage(getString(R.string.delete_fac_dialog))
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->
                    viewModel.deleteFaculty(facID)
                    viewModel.getFacultyResponse.observe(viewLifecycleOwner){
                        when (it) {
                            is Resource.Success -> {
                                Toast.makeText(requireContext(), getString(R.string.fac_del_success), Toast.LENGTH_SHORT).show()
                                parentFragmentManager.beginTransaction().apply {
                                    replace(R.id.frag_faculty_fl, FacultyFragment())
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
        if (binding.editEditFacName.length() == 0) {
            Toast.makeText(requireContext(), getString(R.string.fac_name_mt), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}