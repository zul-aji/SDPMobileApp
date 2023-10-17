package com.tsu.sdp_mobile_app.admin.ui.coursework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.admin.data.response.CourseworkItem
import com.tsu.sdp_mobile_app.admin.data.response.FacultyItem
import com.tsu.sdp_mobile_app.databinding.RecyclerFgpBinding

class CourseworkAdapter (
    private var facList: List<CourseworkItem>
) : RecyclerView.Adapter<CourseworkAdapter.CourseworkViewHolder>() {

    class CourseworkViewHolder (binding: RecyclerFgpBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseworkViewHolder {
        val binding = RecyclerFgpBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return CourseworkViewHolder(binding)
    }

    override fun getItemCount(): Int = facList.size

    override fun onBindViewHolder(holder: CourseworkViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}