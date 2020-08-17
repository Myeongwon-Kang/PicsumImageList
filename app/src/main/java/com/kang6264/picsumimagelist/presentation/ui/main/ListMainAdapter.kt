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

class ListMainAdapter : PagedListAdapter<Picsum, ListMainAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(
        val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.picsum?.let { picsum ->
                    navigateToDetail(picsum, it)
                }
            }
        }

        private fun navigateToDetail(
            picsum: Picsum,
            view: View
        ) {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(picsum)
            view.findNavController().navigate(action)
        }
    }

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