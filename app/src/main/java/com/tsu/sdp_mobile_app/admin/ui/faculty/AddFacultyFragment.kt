package com.tsu.sdp_mobile_app.admin.ui.faculty

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddFacultyBinding

class AddFacultyFragment : BaseFragment<FacultyViewModel, FragmentAddFacultyBinding, FacultyRepo>() {

    private var isAllFieldsChecked = false
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

        binding.addAddFacButton.setOnClickListener {
            val facultyName = binding.addFacultyName.text.toString()

            isAllFieldsChecked = checkAllFields()
            if (isAllFieldsChecked){
                viewModel.createFaculty(facultyName)
                viewModel.getFacultyResponse.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Success -> {
                            Toast.makeText(requireContext(), getString(R.string.fac_made_success), Toast.LENGTH_SHORT).show()
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
        }
    }

    private fun checkAllFields(): Boolean {
        if (binding.addFacultyName.length() == 0) {
            Toast.makeText(requireContext(), getString(R.string.fac_name_mt), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}