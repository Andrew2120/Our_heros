package com.andrew.ourheros.data.remote

import com.andrew.ourheros.data.remote.dto.HeroDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OurHeroesServiceApi {
    @GET("all.json")
    suspend fun getAllHeroes(): List<HeroDto>


    @GET("id/{heroId}.json")
    suspend fun getHero(@Path("heroId") heroId: String): HeroDto
}