package com.task.papbfinalproject.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    @SerializedName("idEvent")
    var idEvent: String = "",
    @SerializedName("idSoccerXML")
    var idSoccerXML: String = "",
    @SerializedName("strEvent")
    var strEvent: String = "",
    @SerializedName("idLeague")
    var idLeague: String = "",
    @SerializedName("strLeague")
    var strLeague: String = "",
    @SerializedName("strDescriptionEN")
    var strDescriptionEN: String = "",
    @SerializedName("strHomeTeam")
    var strHomeTeam: String = "",
    @SerializedName("strAwayTeam")
    var strAwayTeam: String = "",
    @SerializedName("intHomeScore")
    var intHomeScore: String = "",
    @SerializedName("intAwayScore")
    var intAwayScore: String = "",
    @SerializedName("intRound")
    var intRound: String = "",
    @SerializedName("strHomeGoalDetails")
    var strHomeGoalDetails: String = "",
    @SerializedName("strHomeRedCards")
    var strHomeRedCards: String = "",
    @SerializedName("strHomeYellowCards")
    var strHomeYellowCards: String = "",
    @SerializedName("strHomeLineupGoalkeeper")
    var strHomeLineupGoalkeeper: String = "",
    @SerializedName("strHomeLineupDefense")
    var strHomeLineupDefense: String = "",
    @SerializedName("strHomeLineupMidfield")
    var strHomeLineupMidfield: String = "",
    @SerializedName("strHomeLineupForward")
    var strHomeLineupForward: String = "",
    @SerializedName("strHomeLineupSubstitutes")
    var strHomeLineupSubstitutes: String = "",
    @SerializedName("strAwayGoalDetails")
    var strAwayGoalDetails: String = "",
    @SerializedName("strAwayRedCards")
    var strAwayRedCards: String = "",
    @SerializedName("strAwayYellowCards")
    var strAwayYellowCards: String = "",
    @SerializedName("strAwayLineupGoalkeeper")
    var strAwayLineupGoalkeeper: String = "",
    @SerializedName("strAwayLineupDefense")
    var strAwayLineupDefense: String = "",
    @SerializedName("strAwayLineupMidfield")
    var strAwayLineupMidfield: String = "",
    @SerializedName("strAwayLineupForward")
    var strAwayLineupForward: String = "",
    @SerializedName("strAwayLineupSubstitutes")
    var strAwayLineupSubstitutes: String = "",
    @SerializedName("dateEvent")
    var dateEvent: String = "",
    @SerializedName("idHomeTeam")
    var idHomeTeam: String = "",
    @SerializedName("idAwayTeam")
    var idAwayTeam: String = "",
    @SerializedName("strThumb")
    var strThumb: String = ""
    ) : Parcelable
