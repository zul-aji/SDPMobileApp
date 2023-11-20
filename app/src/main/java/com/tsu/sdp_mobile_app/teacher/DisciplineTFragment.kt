package com.tsu.sdp_mobile_app.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.repository.DisciplineTRepo
import com.tsu.sdp_mobile_app.databinding.FragmentDisciplineTBinding

class DisciplineTFragment :
    BaseFragment<DisciplineTViewModel, FragmentDisciplineTBinding, DisciplineTRepo>() {
    override fun getViewModel() = DisciplineTViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDisciplineTBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = DisciplineTRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

}