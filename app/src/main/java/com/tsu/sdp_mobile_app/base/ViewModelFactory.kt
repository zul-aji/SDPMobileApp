package com.tsu.sdp_mobile_app.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tsu.sdp_mobile_app.admin.data.repository.BaseRepo
import com.tsu.sdp_mobile_app.admin.data.repository.DirectionRepo
import com.tsu.sdp_mobile_app.admin.data.repository.DisciplineRepo
import com.tsu.sdp_mobile_app.admin.data.repository.FacultyRepo
import com.tsu.sdp_mobile_app.admin.data.repository.GroupRepo
import com.tsu.sdp_mobile_app.admin.ui.discipline.DisciplineViewModel
import com.tsu.sdp_mobile_app.admin.ui.edudir.EdudirViewModel
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyViewModel
import com.tsu.sdp_mobile_app.admin.ui.group.GroupViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repo: BaseRepo
    ) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(FacultyViewModel::class.java) -> FacultyViewModel(repo as FacultyRepo) as T
            modelClass.isAssignableFrom(GroupViewModel::class.java) -> GroupViewModel(repo as GroupRepo) as T
            modelClass.isAssignableFrom(EdudirViewModel::class.java) -> EdudirViewModel(repo as DirectionRepo) as T
            modelClass.isAssignableFrom(DisciplineViewModel::class.java) -> DisciplineViewModel(repo as DisciplineRepo) as T
            else -> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}