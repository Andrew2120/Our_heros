package com.andrew.ourheros.data.repository

import com.andrew.ourheros.data.remote.OurHeroesServiceApi
import com.andrew.ourheros.data.remote.dto.HeroDto
import com.andrew.ourheros.domain.repository.HeroesRepository

class HeroesRepositoryImp(private val api: OurHeroesServiceApi) : HeroesRepository {
    override suspend fun getHeroes(): List<HeroDto> {
        return api.getAllHeroes()
    }

    override suspend fun getHeroById(heroId: String): HeroDto {
        return api.getHero(heroId)
    }
}