package com.tsu.sdp_mobile_app.admin.ui.edudir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.databinding.FragmentAddEdudirBinding

class AddEdudirFragment : Fragment() {
    private lateinit var binding: FragmentAddEdudirBinding

    companion object {
        fun newInstance() = AddEdudirFragment()
    }

    private lateinit var viewModel: EdudirViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddEdudirBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_edudir_fl, EdudirFragment())
                commit()
            }
        }
    }

}