package com.jhowcs.rickandmortyapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jhowcs.rickandmortyapp.model.Character
import com.jhowcs.rickandmortyapp.service.CharacterService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service: CharacterService = retrofit.create(CharacterService::class.java)

        service.getAllCharacters().enqueue(object : Callback<Character> {
            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.d("CharCall", "failed: ${t.message}")
            }

            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                response.body()?.results?.forEach {
                    Log.d("CharCall", it.name)
                }
            }

        })

    }
}
