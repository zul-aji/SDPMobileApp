package com.tsu.sdp_mobile_app.admin.ui.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.repository.GroupRepo
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddGroupBinding

class AddGroupFragment : BaseFragment<
        GroupViewModel, FragmentAddGroupBinding, GroupRepo>() {
    override fun getViewModel(): Class<GroupViewModel> = GroupViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddGroupBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = GroupRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_group_fl, GroupFragment())
                commit()
            }
        }
    }

}