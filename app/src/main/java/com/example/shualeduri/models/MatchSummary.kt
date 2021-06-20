package com.example.shualeduri.models


import com.google.gson.annotations.SerializedName

data class MatchSummary(
    @SerializedName("summaries")
    val summaries: List<Summary>?
)