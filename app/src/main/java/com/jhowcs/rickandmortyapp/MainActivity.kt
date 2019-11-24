package com.jhowcs.rickandmortyapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jhowcs.rickandmortyapp.model.Result
import com.jhowcs.rickandmortyapp.repository.CharactersRepository
import com.jhowcs.rickandmortyapp.service.CharacterService
import com.jhowcs.rickandmortyapp.service.RestApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RestApi("https://rickandmortyapi.com/api/").getRetrofit()
        val service: CharacterService = retrofit.create(CharacterService::class.java)
        val repository = CharactersRepository(service)
        repository.getAllCharacters(object : CharactersCallback {
            override fun onError(message: String) {
                Log.d("CharCall", "failed: $message")
            }

            override fun onSuccess(results: List<Result>) {
                results.forEach {
                    Log.d("CharCall", it.name)
                }
            }
        })
    }
}
