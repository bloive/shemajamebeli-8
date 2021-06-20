package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class ActionX(
    @SerializedName("goalType")
    val goalType: Int?,
    @SerializedName("player")
    val player: PlayerX?,
    @SerializedName("player1")
    val player1: Player1X?,
    @SerializedName("player2")
    val player2: Player2X?
)