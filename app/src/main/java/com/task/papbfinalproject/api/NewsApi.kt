package com.yudhapn.footballapp.api

import com.task.papbfinalproject.model.ResultEvents
import com.task.papbfinalproject.model.ResultTeams
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("eventspastleague.php")
    fun getLastEventAsync(
        @Query("id") id: String
    ): Deferred<ResultEvents>

    @GET("eventsnextleague.php")
    fun getNextEventAsync(
        @Query("id") id: String
    ): Deferred<ResultEvents>

    @GET("lookup_all_teams.php")
    fun getAllTeamAsync(
        @Query("id") id: String
    ): Deferred<ResultTeams>
}
