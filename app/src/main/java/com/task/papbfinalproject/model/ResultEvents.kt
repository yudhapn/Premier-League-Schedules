package com.task.papbfinalproject.model

import com.google.gson.annotations.SerializedName

data class ResultEvents(
    @SerializedName("events")
    val events: List<Event>
)