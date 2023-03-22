package com.example.musicwiki.dataclasses


import com.google.gson.annotations.SerializedName

data class ImageXXXX(
    val size: String,
    @SerializedName("#text")
    val text: String
)