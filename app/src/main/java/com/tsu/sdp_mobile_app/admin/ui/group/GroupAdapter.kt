package com.tsu.sdp_mobile_app.admin.ui.group

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.admin.data.response.Group
import com.tsu.sdp_mobile_app.databinding.RecyclerFgpBinding

class GroupAdapter (
    private var facList: List<Group>
) : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {

    class GroupViewHolder (binding: RecyclerFgpBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = RecyclerFgpBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return GroupViewHolder(binding)
    }

    override fun getItemCount(): Int = facList.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}