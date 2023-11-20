package com.tsu.sdp_mobile_app.admin.ui.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.network.Resource
import com.tsu.sdp_mobile_app.data.repository.GroupRepo
import com.tsu.sdp_mobile_app.data.response.GroupRequest
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.edudir.EdudirFragment
import com.tsu.sdp_mobile_app.databinding.FragmentAddGroupBinding

class AddGroupFragment : BaseFragment<
        GroupViewModel, FragmentAddGroupBinding, GroupRepo>() {

    private val dirsIDList = ArrayList<String>()
    private val dirsNameList = ArrayList<String>()
    private var isAllFieldsChecked = false

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

        viewModel.getDirections()
        viewModel.getDirectionsResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    val directions = it.value.result.directions
                    directions.forEachIndexed { _, dirItem ->
                        val directionsID = dirItem.direction_id
                        val directionsName = dirItem.direction_name
                        dirsIDList.add(directionsID)
                        dirsNameList.add(directionsName)
                    }

                    val spinValue = binding.groupEdudirSpin
                    val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, dirsNameList)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinValue.adapter = adapter
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

        binding.addAddGroupButton.setOnClickListener {
            val groupName = binding.addGroupName.text.toString()
            val directionID = dirsIDList[binding.groupEdudirSpin.selectedItemPosition]
            val newGroup = GroupRequest(directionID, groupName)

            isAllFieldsChecked = checkAllFields()
            if (isAllFieldsChecked) {
                viewModel.createGroup(newGroup)
                viewModel.createGroupResponse.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Success -> {
                            Toast.makeText(requireContext(), getString(R.string.group_made_success), Toast.LENGTH_SHORT).show()
                            parentFragmentManager.beginTransaction().apply {
                                replace(R.id.frag_group_fl, GroupFragment())
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
        if (binding.addGroupName.length() == 0) {
            Toast.makeText(requireContext(), getString(R.string.dir_name_mt), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}