package com.andrew.ourheros.domain.repository

import com.andrew.ourheros.data.remote.dto.HeroDto

interface HeroesRepository {
    suspend fun getHeroes(): List<HeroDto>

    suspend fun getHeroById(heroId: String): HeroDto

}