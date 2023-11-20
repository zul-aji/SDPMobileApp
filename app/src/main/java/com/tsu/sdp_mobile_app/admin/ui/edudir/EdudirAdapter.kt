package com.tsu.sdp_mobile_app.admin.ui.edudir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.data.response.Direction
import com.tsu.sdp_mobile_app.admin.ui.faculty.FacultyAdapter
import com.tsu.sdp_mobile_app.databinding.RecyclerItemBinding

class EdudirAdapter (
    private var dirList: List<Direction>,
    private var listener: GoToEditFragment
) : RecyclerView.Adapter<EdudirAdapter.EdudirViewHolder>() {

    class EdudirViewHolder (binding: RecyclerItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EdudirViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return EdudirViewHolder(binding)
    }

    override fun getItemCount(): Int = dirList.size

    override fun onBindViewHolder(holder: EdudirViewHolder, position: Int) {
        holder.item.text = dirList[position].direction_name

        holder.item.setOnClickListener {
            listener.goToEditFragment(dirList[position].direction_id, dirList[position].faculty_id)
        }
    }

    interface GoToEditFragment {
        fun goToEditFragment(dirId: String, facId: String)
    }
}