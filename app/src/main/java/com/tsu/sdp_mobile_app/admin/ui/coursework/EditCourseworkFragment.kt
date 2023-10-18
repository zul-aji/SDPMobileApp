package com.tsu.sdp_mobile_app.admin.ui.coursework

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R

class EditCourseworkFragment : Fragment() {

    companion object {
        fun newInstance() = EditCourseworkFragment()
    }

    private lateinit var viewModel: EditCourseworkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_coursework, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditCourseworkViewModel::class.java)
        // TODO: Use the ViewModel
    }

}