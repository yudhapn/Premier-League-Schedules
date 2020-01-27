package com.task.papbfinalproject.repository

import com.task.papbfinalproject.model.Event
import com.task.papbfinalproject.model.Team
import com.yudhapn.footballapp.api.NewsApi

class FootballRepository(private val service: NewsApi) {

    suspend fun getEvent(id: String, eventType: String): List<Event> {
        val events = mutableListOf<Event>()

        val request = if (eventType == "next") {
            service.getNextEventAsync(id).await()
        } else {
            service.getLastEventAsync(id).await()
        }
        request.events.forEach {
            events.add(it)
        }
        return events
    }

    suspend fun getAllTeam(id: String): List<Team> {
        val teams= mutableListOf<Team>()
        val request = service.getAllTeamAsync(id).await()
        request.events.forEach {
            teams.add(it)
        }
        return teams
    }
}
