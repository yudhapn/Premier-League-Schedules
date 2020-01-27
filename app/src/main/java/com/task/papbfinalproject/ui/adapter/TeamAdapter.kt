package com.task.papbfinalproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.task.papbfinalproject.databinding.ItemTeamsBinding
import com.task.papbfinalproject.model.Team
import com.task.papbfinalproject.ui.adapter.TeamAdapter.ViewHolder.Companion.from

class TeamAdapter(private val clickListener: TeamListener) :
    ListAdapter<Team, TeamAdapter.ViewHolder>(TeamDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position), clickListener)

    class ViewHolder private constructor(private val binding: ItemTeamsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team, clickListener: TeamListener) {
            binding.team = team
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) = ViewHolder(
                ItemTeamsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}

class TeamDiffCallback : DiffUtil.ItemCallback<Team>() {
    override fun areItemsTheSame(oldItem: Team, newItem: Team) =
        oldItem.idTeam == newItem.idTeam

    override fun areContentsTheSame(oldItem: Team, newItem: Team) =
        oldItem == newItem
}

class TeamListener(val clickListener: (team: Team) -> Unit) {
    fun onClick(team: Team) = clickListener(team)
}