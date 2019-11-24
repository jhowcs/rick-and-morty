package com.jhowcs.rickandmortyapp.di

import com.jhowcs.rickandmortyapp.repository.CharactersRepository
import com.jhowcs.rickandmortyapp.service.CharacterService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun providesCharacterService(retrofit: Retrofit): CharacterService {
        return retrofit.create(CharacterService::class.java)
    }

    @Provides
    fun providesRepository(service: CharacterService): CharactersRepository {
        return CharactersRepository(service)
    }
}