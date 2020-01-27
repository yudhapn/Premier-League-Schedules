package com.task.papbfinalproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.task.papbfinalproject.databinding.ItemAvatarBinding
import com.task.papbfinalproject.model.Avatar
import com.task.papbfinalproject.ui.adapter.AvatarAdapter.ViewHolder.Companion.from

class AvatarAdapter(private val clickListener: AvatarListener) :
    ListAdapter<Avatar, AvatarAdapter.ViewHolder>(AvatarDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position), clickListener)

    class ViewHolder private constructor(private val binding: ItemAvatarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(avatar: Avatar, clickListener: AvatarListener) {
            binding.avatar = avatar
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) = ViewHolder(
                ItemAvatarBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}

class AvatarDiffCallback : DiffUtil.ItemCallback<Avatar>() {
    override fun areItemsTheSame(oldItem: Avatar, newItem: Avatar) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Avatar, newItem: Avatar) =
        oldItem == newItem
}

class AvatarListener(val clickListener: (avatar: Avatar) -> Unit) {
    fun onClick(avatar: Avatar) = clickListener(avatar)
}