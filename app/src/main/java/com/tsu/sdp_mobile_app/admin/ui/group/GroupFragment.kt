package com.tsu.sdp_mobile_app.admin.ui.group

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.ui.faculty.AddFacultyFragment
import com.tsu.sdp_mobile_app.databinding.FragmentGroupBinding

class GroupFragment : Fragment() {
    private lateinit var binding: FragmentGroupBinding

    companion object {
        fun newInstance() = GroupFragment()
    }

    private lateinit var viewModel: GroupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GroupViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addGroups.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_group_fl, AddGroupFragment())
                commit()
            }
        }
    }

}