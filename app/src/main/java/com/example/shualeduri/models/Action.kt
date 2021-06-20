package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class Action(
    @SerializedName("player")
    val player: Player?,
    @SerializedName("player1")
    val player1: Player1?,
    @SerializedName("player2")
    val player2: Player2?,
    @SerializedName("goalType")
    val goalType: Int?
)