package com.tsu.sdp_mobile_app.admin.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tsu.sdp_mobile_app.admin.data.repository.BaseRepo
import com.tsu.sdp_mobile_app.admin.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repo: BaseRepo
    ) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(FacultyViewModel::class.java) -> FacultyViewModel(repo as FacultyRepo) as T
            else -> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}