package com.tsu.sdp_mobile_app.admin.ui.programme

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R

class AddProgrammeFragment : Fragment() {

    companion object {
        fun newInstance() = AddProgrammeFragment()
    }

    private lateinit var viewModel: AddProgrammeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_programme, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddProgrammeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}