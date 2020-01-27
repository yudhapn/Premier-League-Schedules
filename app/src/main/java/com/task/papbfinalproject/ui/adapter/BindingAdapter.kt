package com.task.papbfinalproject.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.task.papbfinalproject.R
import com.task.papbfinalproject.util.getImage
import com.task.papbfinalproject.model.Event
import com.task.papbfinalproject.model.Team
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("teamData")
fun RecyclerView.bindRvTeam(data: List<Team>?) {
    val adapter = adapter as TeamAdapter
    adapter.submitList(data)
}

@BindingAdapter("newsData")
fun RecyclerView.bindRvNews(data: List<Event>?) {
    val adapter = adapter as EventAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    Glide.with(context).load(url).placeholder(context.getDrawable(R.drawable.poster_premier_league))
        .into(this)
}

@BindingAdapter("setBadge")
fun ImageView.setBadge(idTeam: String?) {
    val imageId = getImage(idTeam)
    Glide.with(context).load(imageId).placeholder(context.getDrawable(R.drawable.poster_premier_league))
        .into(this)
}

@BindingAdapter("setAvatar")
fun CircleImageView.setAvatar(image: Int) {
    setImageResource(image)
}