package com.example.musicwiki.dataclasses


import com.google.gson.annotations.SerializedName

data class ImageX(
    val size: String,
    @SerializedName("#text")
    val text: String
)