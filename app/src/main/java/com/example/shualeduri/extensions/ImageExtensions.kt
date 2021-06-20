package com.example.shualeduri.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.shualeduri.R

fun ImageView.glideImg(url: String) {
    Glide.with(this.context).load(url).placeholder(R.drawable.ic_top_players).into(this)
}