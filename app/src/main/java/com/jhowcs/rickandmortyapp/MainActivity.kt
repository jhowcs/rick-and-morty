package com.jhowcs.rickandmortyapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jhowcs.rickandmortyapp.model.Result
import com.jhowcs.rickandmortyapp.repository.CharactersRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: CharactersRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as CustomApp).appComponent.inject(this)

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
