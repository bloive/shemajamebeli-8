package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class Team1Action(
    @SerializedName("actionType")
    val actionType: Int?,
    @SerializedName("teamType")
    val teamType: Int?,
    @SerializedName("action")
    val action: Action?
)