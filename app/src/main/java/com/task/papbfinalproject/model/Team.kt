package com.task.papbfinalproject.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    @SerializedName("idTeam")
    var idTeam: String = "",
    @SerializedName("idSoccerXML")
    var idSoccerXML: String = "",
    @SerializedName("strTeam")
    var strTeam: String = "",
    @SerializedName("intFormedYear")
    var intFormedYear: String = "",
    @SerializedName("strLeague")
    var strLeague: String = "",
    @SerializedName("strStadium")
    var strStadium: String = "",
    @SerializedName("strStadiumThumb")
    var strStadiumThumb: String = "",
    @SerializedName("strStadiumDescription")
    var strStadiumDescription: String = "",
    @SerializedName("strStadiumLocation")
    var strStadiumLocation: String = "",
    @SerializedName("intStadiumCapacity")
    var intStadiumCapacity: String = "",
    @SerializedName("strWebsite")
    var strWebsite: String = "",
    @SerializedName("strDescriptionEN")
    var strDescriptionEN: String = "",
    @SerializedName("strTeamBadge")
    var strTeamBadge: String = "",
    @SerializedName("strTeamJersey")
    var strTeamJersey: String = ""
) : Parcelable
