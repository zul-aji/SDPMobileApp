package com.tsu.sdp_mobile_app.admin.ui.request

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsu.sdp_mobile_app.MainActivity
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.repository.RequestRepo
import com.tsu.sdp_mobile_app.databinding.FragmentRequestBinding

class RequestFragment : BaseFragment<RequestViewModel, FragmentRequestBinding, RequestRepo>() {
    override fun getViewModel() = RequestViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRequestBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = RequestRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.requestRv.layoutManager = LinearLayoutManager(activity)

        binding.backArrow.setOnClickListener{
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            requireActivity().finish()
        }
    }


}