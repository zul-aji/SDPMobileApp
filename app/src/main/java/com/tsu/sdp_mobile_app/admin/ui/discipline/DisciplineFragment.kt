package com.tsu.sdp_mobile_app.admin.ui.discipline

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.DisciplineRepo
import com.tsu.sdp_mobile_app.admin.data.response.Discipline
import com.tsu.sdp_mobile_app.admin.data.response.Faculty
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.edudir.EdudirAdapter
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyAdapter
import com.tsu.sdp_mobile_app.databinding.FragmentDisciplineBinding

class DisciplineFragment:
    BaseFragment<DisciplineViewModel, FragmentDisciplineBinding, DisciplineRepo>() {

    private lateinit var disAdapter: DisciplineAdapter
    private val dissList = ArrayList<Discipline>()

    override fun getViewModel() = DisciplineViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDisciplineBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = DisciplineRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.disciplineRv.layoutManager = LinearLayoutManager(activity)

        viewModel.getDisciplines()
        viewModel.getDisciplinesResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    val disciplines = it.value.result.disciplines
                    disciplines.forEachIndexed { _, dissItem ->
                        val discipline = Discipline(
                            discipline_id = dissItem.discipline_id,
                            discipline_name = dissItem.discipline_name,
                            description = dissItem.description,
                            literature = dissItem.literature,
                            year = dissItem.year,
                            grade_id = dissItem.grade_id,
                            is_online = dissItem.is_online,
                            building = dissItem.building,
                            room = dissItem.room
                        )
                        dissList.add(discipline)

                        disAdapter = DisciplineAdapter(dissList)
                        binding.disciplineRv.adapter = disAdapter
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

        binding.addDisciplineBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_discipline_fl, AddDisciplineFragment())
                commit()
            }
        }
    }

}