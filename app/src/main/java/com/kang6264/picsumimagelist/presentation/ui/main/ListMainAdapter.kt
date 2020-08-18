package com.kang6264.picsumimagelist.presentation.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kang6264.picsumimagelist.R
import com.kang6264.picsumimagelist.data.response.Picsum
import com.kang6264.picsumimagelist.databinding.ListItemBinding

class ListMainAdapter(private val actionHandler: ActionHandler) :
    PagedListAdapter<Picsum, ListMainAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(
        val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.binding.picsum = it
            holder.binding.actionHandler = actionHandler
            //holder.binding.viewListItem.transitionName = it?.id
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Picsum>() {
    override fun areItemsTheSame(oldItem: Picsum, newItem: Picsum): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Picsum, newItem: Picsum): Boolean {
        return oldItem == newItem
    }

}