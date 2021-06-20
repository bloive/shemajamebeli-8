package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class Summary(
    @SerializedName("actionTime")
    val actionTime: String?,
    @SerializedName("team1Action")
    val team1Action: List<Team1Action>?,
    @SerializedName("team2Action")
    val team2Action: List<Team2Action>?
)