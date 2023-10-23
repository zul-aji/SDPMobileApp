package com.tsu.sdp_mobile_app.admin.ui.discipline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.databinding.FragmentAddDisciplineBinding

class AddDisciplineFragment : Fragment() {
    private lateinit var binding: FragmentAddDisciplineBinding

    companion object {
        fun newInstance() = AddDisciplineFragment()
    }

    private lateinit var viewModel: DisciplineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddDisciplineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_discipline_fl, DisciplineFragment())
                commit()
            }
        }
    }

}