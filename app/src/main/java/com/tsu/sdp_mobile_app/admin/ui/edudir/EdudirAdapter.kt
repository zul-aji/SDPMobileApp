package com.tsu.sdp_mobile_app.admin.ui.edudir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.admin.data.response.Direction
import com.tsu.sdp_mobile_app.databinding.RecyclerFgpBinding

class EdudirAdapter (
    private var dirList: List<Direction>
) : RecyclerView.Adapter<EdudirAdapter.EdudirViewHolder>() {

    class EdudirViewHolder (binding: RecyclerFgpBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EdudirViewHolder {
        val binding = RecyclerFgpBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return EdudirViewHolder(binding)
    }

    override fun getItemCount(): Int = dirList.size

    override fun onBindViewHolder(holder: EdudirViewHolder, position: Int) {
        holder.item.text = dirList[position].direction_name
    }
}