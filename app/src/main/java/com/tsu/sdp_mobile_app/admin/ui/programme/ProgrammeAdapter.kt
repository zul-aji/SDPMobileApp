package com.tsu.sdp_mobile_app.admin.ui.programme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.admin.data.response.CourseworkItem
import com.tsu.sdp_mobile_app.admin.data.response.FacultyItem
import com.tsu.sdp_mobile_app.admin.data.response.GroupItem
import com.tsu.sdp_mobile_app.admin.data.response.ProgrammeItem
import com.tsu.sdp_mobile_app.databinding.RecyclerFgpBinding

class ProgrammeAdapter (
    private var facList: List<ProgrammeItem>
) : RecyclerView.Adapter<ProgrammeAdapter.ProgrammeViewHolder>() {

    class ProgrammeViewHolder (binding: RecyclerFgpBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammeViewHolder {
        val binding = RecyclerFgpBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return ProgrammeViewHolder(binding)
    }

    override fun getItemCount(): Int = facList.size

    override fun onBindViewHolder(holder: ProgrammeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}