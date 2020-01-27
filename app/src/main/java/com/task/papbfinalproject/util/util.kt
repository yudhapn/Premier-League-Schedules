package com.task.papbfinalproject.util

import com.task.papbfinalproject.R

fun getImage(idTeam: String?) = when(idTeam) {
    "133604" -> R.drawable.arsenal
    "133601" -> R.drawable.aston_villa
    "134301" -> R.drawable.bournemouth
    "133619" -> R.drawable.brighton
    "133623" -> R.drawable.burnley
    "133610" -> R.drawable.chelsea
    "133632" -> R.drawable.crystal_palace
    "133615" -> R.drawable.everton
    "133626" -> R.drawable.leicester
    "133602" -> R.drawable.liverpool
    "133613" -> R.drawable.man_city
    "133612" -> R.drawable.man_united
    "134777" -> R.drawable.newcastle
    "133608" -> R.drawable.norwich
    "133811" -> R.drawable.sheffield_united
    "134778" -> R.drawable.southampton
    "133616" -> R.drawable.tottenham
    "133624" -> R.drawable.watford
    "133636" -> R.drawable.west_ham
    "133599" -> R.drawable.wolves
    else -> R.mipmap.ic_launcher
}