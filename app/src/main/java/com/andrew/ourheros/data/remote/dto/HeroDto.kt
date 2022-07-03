package com.andrew.ourheros.data.remote.dto

import com.andrew.ourheros.domain.model.Hero
import com.andrew.ourheros.domain.model.HeroDetails


data class HeroDto(
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

fun HeroDto.toHero(): Hero {
    return Hero(
        id = id,
        name = name,
        images = images
    )
}

fun HeroDto.toHeroDetailed(): HeroDetails {
    return HeroDetails(
        id = id,
        name = name,
        slug = slug,
        images = images,
        powerstats = powerstats,
        appearance = appearance,
        biography = biography,
        work = work,
        connections = connections
    )
}