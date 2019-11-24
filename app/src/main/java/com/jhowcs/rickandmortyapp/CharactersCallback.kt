package com.jhowcs.rickandmortyapp

import com.jhowcs.rickandmortyapp.model.Result

interface CharactersCallback {

    fun onError(message: String)

    fun onSuccess(results: List<Result>)
}