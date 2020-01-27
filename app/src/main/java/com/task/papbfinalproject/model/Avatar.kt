package com.task.papbfinalproject.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.task.papbfinalproject.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Avatar(
    var id: String = "",
    var image: Int = R.drawable.ic_avatar
    ) : Parcelable
