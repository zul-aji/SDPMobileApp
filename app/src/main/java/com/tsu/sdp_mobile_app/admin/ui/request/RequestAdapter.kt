package com.tsu.sdp_mobile_app.admin.ui.request

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsu.sdp_mobile_app.data.response.Group
import com.tsu.sdp_mobile_app.admin.ui.edudir.EdudirAdapter
import com.tsu.sdp_mobile_app.databinding.RecyclerItemBinding
import com.tsu.sdp_mobile_app.databinding.RecyclerItemRequestBinding

class RequestAdapter (
    private var requestList: List<Group>,
) : RecyclerView.Adapter<RequestAdapter.RequestViewHolder>() {

    class RequestViewHolder (binding: RecyclerItemRequestBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val item = binding.item
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val binding = RecyclerItemRequestBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return RequestViewHolder(binding)
    }

    override fun getItemCount(): Int = requestList.size

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
    }
}