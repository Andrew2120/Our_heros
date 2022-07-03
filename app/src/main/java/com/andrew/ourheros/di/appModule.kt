package com.andrew.ourheros.di

import com.andrew.ourheros.comman.Constants.BASE_URL
import com.andrew.ourheros.data.remote.OurHeroesServiceApi
import com.andrew.ourheros.data.repository.HeroesRepositoryImp
import com.andrew.ourheros.domain.repository.HeroesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): OurHeroesServiceApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(OurHeroesServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: OurHeroesServiceApi): HeroesRepository {
        return HeroesRepositoryImp(api)
    }
}
