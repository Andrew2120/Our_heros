package com.andrew.ourheros.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Powerstats(
    val intelligence: Int?,
    val strength: Int?,
    val speed: Int?,
    val durability: Int?,
    val power: Int?,
    val combat: Int?
)