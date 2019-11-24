package com.jhowcs.rickandmortyapp.repository

import com.jhowcs.rickandmortyapp.CharactersCallback
import com.jhowcs.rickandmortyapp.model.Character
import com.jhowcs.rickandmortyapp.service.CharacterService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersRepository(private val service: CharacterService) {

    fun getAllCharacters(callback: CharactersCallback) {
        service.getAllCharacters().enqueue(object : Callback<Character> {
            override fun onFailure(call: Call<Character>, t: Throwable) {
                callback.onError("error fetching data: ${t.message}")
            }

            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                response.body()?.results?.let {
                    callback.onSuccess(it)
                } ?: callback.onError("data is null")
            }

        })
    }
}