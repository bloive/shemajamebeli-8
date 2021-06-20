package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class Team2Action(
    @SerializedName("action")
    val action: ActionX?,
    @SerializedName("actionType")
    val actionType: Int?,
    @SerializedName("teamType")
    val teamType: Int?
)