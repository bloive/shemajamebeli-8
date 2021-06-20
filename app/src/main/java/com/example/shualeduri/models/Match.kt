package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("team1")
    val team1: Team1?,
    @SerializedName("team2")
    val team2: Team2?,
    @SerializedName("matchTime")
    val matchTime: Double?,
    @SerializedName("matchDate")
    val matchDate: Long?,
    @SerializedName("stadiumAdress")
    val stadiumAdress: String?,
    @SerializedName("matchSummary")
    val matchSummary: MatchSummary?

)