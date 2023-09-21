package com.tsu.sdp_mobile_app.ui.autumn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tsu.sdp_mobile_app.databinding.FragmentAutumnBinding
import com.tsu.sdp_mobile_app.ui.autumn.AutumnViewModel

class AutumnFragment : Fragment() {

    private var _binding: FragmentAutumnBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val autumnViewModel =
            ViewModelProvider(this).get(AutumnViewModel::class.java)

        _binding = FragmentAutumnBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        autumnViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}