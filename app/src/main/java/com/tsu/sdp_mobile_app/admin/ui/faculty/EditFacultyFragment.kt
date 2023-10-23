package com.tsu.sdp_mobile_app.admin.ui.faculty

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R

class EditFacultyFragment : Fragment() {

    companion object {
        fun newInstance() = EditFacultyFragment()
    }

    private lateinit var viewModel: FacultyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_faculty, container, false)
    }

}