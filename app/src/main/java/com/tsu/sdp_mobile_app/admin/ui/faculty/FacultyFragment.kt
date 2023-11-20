package com.tsu.sdp_mobile_app.admin.ui.faculty

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsu.sdp_mobile_app.MainActivity
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.network.Resource
import com.tsu.sdp_mobile_app.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.data.response.Faculty
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentFacultyBinding

class FacultyFragment :
    BaseFragment<FacultyViewModel, FragmentFacultyBinding, FacultyRepo>(), FacultyAdapter.GoToEditFragment {

    private lateinit var facAdapter: FacultyAdapter
    private val facsList = ArrayList<Faculty>()

    override fun getViewModel() = FacultyViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFacultyBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = FacultyRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.facultiesRv.layoutManager = LinearLayoutManager(activity)

        binding.backArrow.setOnClickListener{
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            requireActivity().finish()
        }

        viewModel.getFaculties()
        viewModel.getFacultiesResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    val faculties = it.value.result.faculties
                    faculties.forEachIndexed { _, facItem ->
                        val faculty = Faculty(
                            faculty_id = facItem.faculty_id,
                            faculty_name = facItem.faculty_name
                        )
                        facsList.add(faculty)

                        facAdapter = FacultyAdapter(facsList, this)
                        binding.facultiesRv.adapter = facAdapter
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

        binding.addFacultiesBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_faculty_fl, AddFacultyFragment())
                commit()
            }
        }
    }

    override fun goToEditFragment(facultyId: String) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.frag_faculty_fl, EditFacultyFragment(facultyId))
            commit()
        }
    }
}
