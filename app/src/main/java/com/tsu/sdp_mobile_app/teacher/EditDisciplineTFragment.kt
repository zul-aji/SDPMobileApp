package com.tsu.sdp_mobile_app.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.repository.DisciplineTRepo
import com.tsu.sdp_mobile_app.databinding.FragmentEditDisciplineTBinding

class EditDisciplineTFragment(disctId: String) : BaseFragment<
        DisciplineTViewModel, FragmentEditDisciplineTBinding, DisciplineTRepo>() {
    override fun getViewModel() = DisciplineTViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEditDisciplineTBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = DisciplineTRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

}