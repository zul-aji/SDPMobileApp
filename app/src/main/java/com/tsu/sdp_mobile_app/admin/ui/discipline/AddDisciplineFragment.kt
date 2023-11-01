package com.tsu.sdp_mobile_app.admin.ui.discipline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.repository.DisciplineRepo
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddDisciplineBinding

class AddDisciplineFragment : BaseFragment<
        DisciplineViewModel, FragmentAddDisciplineBinding, DisciplineRepo>() {
    override fun getViewModel(): Class<DisciplineViewModel> = DisciplineViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddDisciplineBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = DisciplineRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_discipline_fl, DisciplineFragment())
                commit()
            }
        }
    }

}