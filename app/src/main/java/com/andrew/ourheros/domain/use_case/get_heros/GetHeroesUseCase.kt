package com.andrew.ourheros.domain.use_case.get_heros

import com.andrew.ourheros.comman.Resource
import com.andrew.ourheros.data.remote.dto.toHero
import com.andrew.ourheros.domain.model.Hero
import com.andrew.ourheros.domain.repository.HeroesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(
    private val repository: HeroesRepository
) {
    operator fun invoke(): Flow<Resource<List<Hero>>> = flow {
        try {
            emit(Resource.Loading<List<Hero>>())
            val heroes = repository.getHeroes().map { it.toHero() }
            emit(Resource.Success<List<Hero>>(heroes))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Hero>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Hero>>("Couldn't reach server. Check your internet connection."))
        }
    }
}