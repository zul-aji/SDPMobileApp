package com.tsu.sdp_mobile_app.admin.ui.faculty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.admin.data.response.FacultyItem
import com.tsu.sdp_mobile_app.databinding.RecyclerFgpBinding

class FacultyAdapter (
    private var facList: List<FacultyItem>
) : RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {

    class FacultyViewHolder (binding: RecyclerFgpBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val binding = RecyclerFgpBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return FacultyViewHolder(binding)
    }

    override fun getItemCount(): Int = facList.size

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}