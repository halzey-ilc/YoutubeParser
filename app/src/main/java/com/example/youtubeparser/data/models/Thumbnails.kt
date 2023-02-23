package com.example.youtubeparser.data.models

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("standart")
    val standart: Standart,

    @SerializedName("(key)")
    val Key: Key
)
