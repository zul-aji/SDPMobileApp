package com.tsu.sdp_mobile_app.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.data.response.Direction
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyAdapter
import com.tsu.sdp_mobile_app.data.response.Discipline
import com.tsu.sdp_mobile_app.databinding.RecyclerItemBinding

class DisciplineTAdapter (
    private var disctList: List<Discipline>,
    private var listener: GoToEditFragment
) : RecyclerView.Adapter<DisciplineTAdapter.DiscTViewHolder>() {

    class DiscTViewHolder (binding: RecyclerItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscTViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return DiscTViewHolder(binding)
    }

    override fun getItemCount(): Int = disctList.size

    override fun onBindViewHolder(holder: DiscTViewHolder, position: Int) {
        holder.item.text = disctList[position].discipline_name

        holder.item.setOnClickListener {
            listener.goToEditFragment(disctList[position].discipline_id)
        }
    }

    interface GoToEditFragment {
        fun goToEditFragment(disctId: String)
    }
}