package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("playerName")
    val playerName: String?,
    @SerializedName("playerImage")
    val playerImage: String?
)