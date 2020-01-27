package com.task.papbfinalproject.model

import com.google.gson.annotations.SerializedName

data class ResultTeams(
    @SerializedName("teams")
    val events: List<Team>
)