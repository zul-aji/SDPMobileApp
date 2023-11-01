package com.tsu.sdp_mobile_app.admin.ui.discipline

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tsu.sdp_mobile_app.R
import com.tsu.sdp_mobile_app.admin.data.network.APIRequest
import com.tsu.sdp_mobile_app.admin.data.network.Resource
import com.tsu.sdp_mobile_app.admin.data.repository.DisciplineRepo
import com.tsu.sdp_mobile_app.admin.ui.base.BaseFragment
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyFragment
import com.tsu.sdp_mobile_app.admin.ui.group.GroupFragment
import com.tsu.sdp_mobile_app.databinding.FragmentEditDisciplineBinding

class EditDisciplineFragment(discId: String) : BaseFragment<
        DisciplineViewModel, FragmentEditDisciplineBinding, DisciplineRepo>() {

    private var currDiscID = discId
    override fun getViewModel(): Class<DisciplineViewModel> = DisciplineViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEditDisciplineBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = DisciplineRepo(dataSource.buildAPI(requireContext(), APIRequest::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frag_discipline_fl, DisciplineFragment())
                commit()
            }
        }

        viewModel.getDiscipline(currDiscID)
        viewModel.getDisciplineResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    val discipline = it.value.result.discipline
                    binding.editDisciplineName.setText(discipline.discipline_name)
                    binding.editDisciplineDesc.setText(discipline.description)
                    binding.editDisciplineLiter.setText(discipline.literature)
                    binding.editDisciplineYear.setText(discipline.year.toString())
                    binding.editDisciplineBuild.setText(discipline.building)
                    binding.editDisciplineRoom.setText(discipline.room)
                    binding.editDisciplineOnlineBox.isChecked = discipline.is_online
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

        binding.editDisciplineDeleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(context, R.style.CustomAlertDialogTheme)
            builder.setMessage(getString(R.string.delete_disc_dialog))
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->
                    viewModel.deleteDiscipline(currDiscID)
                    viewModel.getDisciplineResponse.observe(viewLifecycleOwner){
                        when (it) {
                            is Resource.Success -> {
                                Toast.makeText(requireContext(), getString(R.string.disc_del_success), Toast.LENGTH_SHORT).show()
                                parentFragmentManager.beginTransaction().apply {
                                    replace(R.id.frag_discipline_fl, DisciplineFragment())
                                    commit()
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
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }

}