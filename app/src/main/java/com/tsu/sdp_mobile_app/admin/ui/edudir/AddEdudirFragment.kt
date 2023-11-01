package com.tsu.sdp_mobile_app.admin.ui.edudir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.repository.DirectionRepo
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddEdudirBinding

class AddEdudirFragment : BaseFragment<
        EdudirViewModel, FragmentAddEdudirBinding, DirectionRepo>()
{

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
    }

}