package com.jhowcs.rickandmortyapp.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestApi(private val baseUrl: String) {

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

}