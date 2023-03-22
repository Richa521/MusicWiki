package com.example.musicwiki.dataclasses


import com.google.gson.annotations.SerializedName

data class Toptags(
    @SerializedName("@attr")
    val attr: Attr,
    val tag: List<Tag>
)