package com.tsu.sdp_mobile_app.admin.ui.group

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.admin.data.response.Group
import com.tsu.sdp_mobile_app.admin.ui.edudir.EdudirAdapter
import com.tsu.sdp_mobile_app.databinding.RecyclerItemBinding

class GroupAdapter (
    private var groupList: List<Group>,
    private var listener: GoToEditFragment
) : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {

    class GroupViewHolder (binding: RecyclerItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return GroupViewHolder(binding)
    }

    override fun getItemCount(): Int = groupList.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.item.text = groupList[position].group_name

        holder.item.setOnClickListener {
            listener.goToEditFragment(groupList[position].group_id, groupList[position].direction_id)
        }
    }

    interface GoToEditFragment {
        fun goToEditFragment(groupId: String, dirId: String)
    }
}