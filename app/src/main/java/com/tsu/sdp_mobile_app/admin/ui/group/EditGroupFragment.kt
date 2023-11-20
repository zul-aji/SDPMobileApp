package com.tsu.sdp_mobile_app.admin.ui.group

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
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
import com.tsu.sdp_mobile_app.data.response.Group
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.edudir.EdudirFragment
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyFragment
import com.tsu.sdp_mobile_app.databinding.FragmentEditGroupBinding

class EditGroupFragment(groupId: String, dirId: String) : BaseFragment<
        GroupViewModel, FragmentEditGroupBinding, GroupRepo>(){

    private val dirsIDList = ArrayList<String>()
    private val dirsNameList = ArrayList<String>()
    private var groupID = groupId
    private var currDirID = dirId
    private var isAllFieldsChecked = false
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
        val spinValue = binding.editGroupEdudirSpin
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, dirsNameList)

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

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinValue.adapter = adapter
                    for ((index, directionId) in dirsIDList.withIndex()) {
                        if (directionId == currDirID) {
                            currIndex = index
                            Log.e("index", currIndex.toString() )
                            break
                        }
                    }
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

        viewModel.getGroup(groupID)
        viewModel.getGroupResponse.observe(viewLifecycleOwner){
            when (it) {
                is Resource.Success -> {
                    binding.editGroupName.setText(it.value.result.group.group_name)
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

        binding.editGroupSaveButton.setOnClickListener {
            val groupid = dirsIDList[spinValue.selectedItemId.toInt()]
            val groupname = binding.editGroupName.text.toString()
            val groupDet = Group(groupID, groupid, groupname)

            isAllFieldsChecked = checkAllFields()
            if (isAllFieldsChecked) {
                viewModel.updateGroup(groupID, groupDet)
                viewModel.getGroupResponse.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Success -> {
                            Toast.makeText(requireContext(), getString(R.string.group_up_success), Toast.LENGTH_SHORT).show()
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

        binding.editGroupDeleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(context, R.style.CustomAlertDialogTheme)
            builder.setMessage(getString(R.string.delete_group_dialog))
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->
                    viewModel.deleteGroup(groupID)
                    viewModel.getGroupResponse.observe(viewLifecycleOwner){
                        when (it) {
                            is Resource.Success -> {
                                Toast.makeText(requireContext(), getString(R.string.group_del_success), Toast.LENGTH_SHORT).show()
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
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }

    private fun checkAllFields(): Boolean {
        if (binding.editGroupName.length() == 0) {
            Toast.makeText(requireContext(), getString(R.string.dir_name_mt), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}