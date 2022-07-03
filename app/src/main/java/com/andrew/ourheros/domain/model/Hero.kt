package com.andrew.ourheros.domain.model

import com.andrew.ourheros.data.remote.dto.Images

data class Hero(
    val id: Int,
    val name: String,
    val images: Images
)