package com.tsu.sdp_mobile_app.admin.ui.faculty

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R

class AddFacultyFragment : Fragment() {

    companion object {
        fun newInstance() = AddFacultyFragment()
    }

    private lateinit var viewModel: AddFacultyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_faculty, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddFacultyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}