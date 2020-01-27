package com.task.papbfinalproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.task.papbfinalproject.databinding.ItemEventBinding
import com.task.papbfinalproject.model.Event
import com.task.papbfinalproject.ui.adapter.EventAdapter.ViewHolder.Companion.from


class EventAdapter(private val clickListener: EventListener) :
    ListAdapter<Event, EventAdapter.ViewHolder>(NewsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position), clickListener)

    class ViewHolder private constructor(private val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event, clickListener: EventListener) {
            binding.event = event
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }



        companion object {
            fun from(parent: ViewGroup) = ViewHolder(
                ItemEventBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}

class NewsDiffCallback : DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event) =
        oldItem.idEvent == newItem.idEvent

    override fun areContentsTheSame(oldItem: Event, newItem: Event) =
        oldItem == newItem
}

class EventListener(val clickListener: (event: Event) -> Unit) {
    fun onClick(event: Event) = clickListener(event)
}