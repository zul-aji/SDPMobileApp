package com.tsu.sdp_mobile_app.admin.ui.group

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.GroupRepo
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.edudir.EdudirFragment
import com.tsu.sdp_mobile_app.databinding.FragmentEditGroupBinding

class EditGroupFragment(groupId: String, dirId: String) : BaseFragment<
        GroupViewModel, FragmentEditGroupBinding, GroupRepo>(){

    private val dirsIDList = ArrayList<String>()
    private val dirsNameList = ArrayList<String>()
    private var groupID = groupId
    private var currDirID = dirId
    override fun getViewModel(): Class<GroupViewModel> = GroupViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEditGroupBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = GroupRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_group_fl, GroupFragment())
                commit()
            }
        }

        var currIndex = 0

        viewModel.getDirections()
        viewModel.getDirectionsResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    val directions = it.value.result.directions
                    directions.forEachIndexed { _, dirItem ->
                        val directionID = dirItem.direction_id
                        val directionName = dirItem.direction_name
                        dirsIDList.add(directionID)
                        dirsNameList.add(directionName)
                    }
                    for ((index, facultyId) in dirsIDList.withIndex()) {
                        if (facultyId == currDirID) {
                            currIndex = index
                            break
                        }
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

        viewModel.getGroup(groupID)
        viewModel.getGroupResponse.observe(viewLifecycleOwner){
            when (it) {
                is Resource.Success -> {
                    binding.editGroupName.setText(it.value.result.group.group_name)
                    val spinValue = binding.editGroupEdudirSpin
                    val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, dirsNameList)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinValue.adapter = adapter
                    spinValue.setSelection(currIndex)
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