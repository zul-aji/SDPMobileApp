package com.tsu.sdp_mobile_app.ui.manage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tsu.sdp_mobile_app.admin.DisciplineActivity
import com.tsu.sdp_mobile_app.admin.FacultyActivity
import com.tsu.sdp_mobile_app.admin.GroupActivity
import com.tsu.sdp_mobile_app.admin.EdudirActivity
import com.tsu.sdp_mobile_app.databinding.FragmentManageBinding

class ManageFragment : Fragment() {

    private var _binding: FragmentManageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val manageViewModel =
//            ViewModelProvider(this)[ManageViewModel::class.java]

        _binding = FragmentManageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.facultyButton.setOnClickListener {
            val nextPage = Intent(context, FacultyActivity::class.java)
            startActivity(nextPage)
        }

        binding.groupsButton.setOnClickListener {
            val nextPage = Intent(context, GroupActivity::class.java)
            startActivity(nextPage)
        }

        binding.directionButton.setOnClickListener {
            val nextPage = Intent(context, EdudirActivity::class.java)
            startActivity(nextPage)
        }

        binding.disciplinesButton.setOnClickListener {
            val nextPage = Intent(context, DisciplineActivity::class.java)
            startActivity(nextPage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}