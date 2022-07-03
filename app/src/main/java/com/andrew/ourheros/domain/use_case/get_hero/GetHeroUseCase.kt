package com.andrew.ourheros.domain.use_case.get_hero

import com.andrew.ourheros.comman.Resource
import com.andrew.ourheros.data.remote.dto.toHeroDetailed
import com.andrew.ourheros.domain.model.HeroDetails
import com.andrew.ourheros.domain.repository.HeroesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHeroUseCase @Inject constructor(
    private val repository: HeroesRepository
) {
    operator fun invoke(heroId: String): Flow<Resource<HeroDetails>> = flow {
        try {
            emit(Resource.Loading<HeroDetails>())
            val heroes = repository.getHeroById(heroId).toHeroDetailed()
            emit(Resource.Success<HeroDetails>(heroes))
        } catch (e: HttpException) {
            emit(Resource.Error<HeroDetails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<HeroDetails>("Couldn't reach server. Check your internet connection."))
        }
    }
}