package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("resultCode")
    val resultCode: Int?,
    @SerializedName("match")
    val match: Match?
)