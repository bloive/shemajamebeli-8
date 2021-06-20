package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class Team1(
    @SerializedName("teamName")
    val teamName: String?,
    @SerializedName("teamImage")
    val teamImage: String?,
    @SerializedName("score")
    val score: Int?,
    @SerializedName("ballPosition")
    val ballPosition: Int?,
)