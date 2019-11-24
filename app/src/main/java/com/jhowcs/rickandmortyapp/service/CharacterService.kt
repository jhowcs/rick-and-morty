package com.jhowcs.rickandmortyapp.service

import com.jhowcs.rickandmortyapp.model.Character
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {

    @GET("character/")
    fun getAllCharacters(): Call<Character>
}