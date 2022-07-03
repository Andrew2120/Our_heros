package com.andrew.ourheros.domain.model

import com.andrew.ourheros.data.remote.dto.*

data class HeroDetails(
    val id: Int,
    val name: String,
    val slug: String?,
    val powerstats: Powerstats?,
    val appearance: Appearance?,
    val biography: Biography?,
    val work: Work?,
    val connections: Connections?,
    val images: Images
)