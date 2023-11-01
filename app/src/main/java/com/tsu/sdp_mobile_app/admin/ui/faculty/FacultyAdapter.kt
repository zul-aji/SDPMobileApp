package com.tsu.sdp_mobile_app.admin.ui.faculty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.admin.data.response.Faculty
import com.tsu.sdp_mobile_app.databinding.RecyclerItemBinding

class FacultyAdapter(
    private var facsList: List<Faculty>,
    private var listener: GoToEditFragment
) : RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {

    class FacultyViewHolder (binding: RecyclerItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return FacultyViewHolder(binding)
    }

    override fun getItemCount(): Int = facsList.size

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        holder.item.text = facsList[position].faculty_name

        holder.item.setOnClickListener {
            listener.goToEditFragment(facsList[position].faculty_id)
        }
    }

    interface GoToEditFragment {
        fun goToEditFragment(facultyId: String)
    }
}