package com.andrew.ourheros.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Appearance(
    val gender: String?,
    val race: String?,
    val height: List<String>?,
    val weight: List<String>?,
    val eyeColor: String?,
    val hairColor: String?
)