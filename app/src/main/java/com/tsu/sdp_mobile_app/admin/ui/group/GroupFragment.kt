package com.tsu.sdp_mobile_app.admin.ui.group

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsu.sdp_mobile_app.MainActivity
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.GroupRepo
import com.tsu.sdp_mobile_app.admin.data.response.Group
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.edudir.EditEdudirFragment
import com.tsu.sdp_mobile_app.databinding.FragmentGroupBinding

class GroupFragment :
    BaseFragment<GroupViewModel, FragmentGroupBinding, GroupRepo>(), GroupAdapter.GoToEditFragment {

    private lateinit var groupAdapter: GroupAdapter
    private val groupsList = ArrayList<Group>()

    override fun getViewModel() = GroupViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentGroupBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = GroupRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.groupsRv.layoutManager = LinearLayoutManager(activity)

        binding.backArrow.setOnClickListener{
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            requireActivity().finish()
        }

        viewModel.getGroups()
        viewModel.getGroupsResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    val groups = it.value.result.groups
                    groups.forEachIndexed { _, groupItem ->
                        val group = Group(
                            group_id = groupItem.group_id,
                            direction_id = groupItem.direction_id,
                            group_name = groupItem.group_name
                        )
                        groupsList.add(group)

                        groupAdapter = GroupAdapter(groupsList, this)
                        binding.groupsRv.adapter = groupAdapter
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

        binding.addGroupsBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_group_fl, AddGroupFragment())
                commit()
            }
        }
    }

    override fun goToEditFragment(groupId: String, dirId: String) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.frag_group_fl, EditGroupFragment(groupId, dirId))
            commit()
        }
    }

}