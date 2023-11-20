package com.tsu.sdp_mobile_app.admin.ui.edudir

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsu.sdp_mobile_app.MainActivity
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.data.network.APIRequest
import com.tsu.sdp_mobile_app.data.network.Resource
import com.tsu.sdp_mobile_app.data.repository.DirectionRepo
import com.tsu.sdp_mobile_app.data.response.Direction
import com.tsu.sdp_mobile_app.base.BaseFragment
import com.tsu.sdp_mobile_app.databinding.FragmentEdudirBinding

class EdudirFragment :
    BaseFragment<EdudirViewModel, FragmentEdudirBinding, DirectionRepo>(), EdudirAdapter.GoToEditFragment {

    private lateinit var dirAdapter: EdudirAdapter
    private val dirsList = ArrayList<Direction>()

    override fun getViewModel() = EdudirViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEdudirBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = DirectionRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.edudirRv.layoutManager = LinearLayoutManager(activity)

        binding.backArrow.setOnClickListener{
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            requireActivity().finish()
        }

        viewModel.getDirections()
        viewModel.getDirectionsResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    val directions = it.value.result.directions
                    directions.forEachIndexed { _, dirItem ->
                        val direction = Direction(
                            direction_id = dirItem.direction_id,
                            faculty_id = dirItem.faculty_id,
                            direction_name = dirItem.direction_name
                        )
                        dirsList.add(direction)

                        dirAdapter = EdudirAdapter(dirsList, this)
                        binding.edudirRv.adapter = dirAdapter
                    }
                }
                is Resource.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        if (it.isNetworkError){ "Network Error" }
                        else { "Fail: ${it.errorMessage.toString()}" },
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    Toast.makeText(
                        requireContext(),
                        "unknown error",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.addEdudirBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_edudir_fl, AddEdudirFragment())
                commit()
            }
        }
    }

    override fun goToEditFragment(dirId: String, facId: String) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.frag_edudir_fl, EditEdudirFragment(dirId, facId))
            commit()
        }
    }
}