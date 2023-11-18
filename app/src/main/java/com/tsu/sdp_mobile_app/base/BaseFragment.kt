package com.tsu.sdp_mobile_app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.tsu.sdp_mobile_app.admin.data.network.DataSource
import com.tsu.sdp_mobile_app.admin.data.repository.BaseRepo

abstract class BaseFragment<VM: ViewModel, B: ViewBinding, R: BaseRepo> : Fragment() {

    protected lateinit var binding: B
    lateinit var viewModel: VM
    protected val dataSource = DataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory)[getViewModel()]
        return binding.root
    }

    abstract fun getViewModel() : Class<VM>
    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) : B
    abstract fun getFragmentRepository() : R
}