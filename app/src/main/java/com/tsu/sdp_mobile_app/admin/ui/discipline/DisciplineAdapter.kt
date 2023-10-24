package com.tsu.sdp_mobile_app.admin.ui.discipline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.admin.data.response.Discipline
import com.tsu.sdp_mobile_app.databinding.RecyclerDisBinding
import com.tsu.sdp_mobile_app.databinding.RecyclerFgpBinding

class DisciplineAdapter (
    private var dissList: List<Discipline>
) : RecyclerView.Adapter<DisciplineAdapter.DisciplineViewHolder>() {

    class DisciplineViewHolder (binding: RecyclerDisBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplineViewHolder {
        val binding = RecyclerDisBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return DisciplineViewHolder(binding)
    }

    override fun getItemCount(): Int = dissList.size

    override fun onBindViewHolder(holder: DisciplineViewHolder, position: Int) {
        holder.item.text = dissList[position].discipline_name
    }
}