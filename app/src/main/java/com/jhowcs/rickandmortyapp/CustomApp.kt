package com.jhowcs.rickandmortyapp

import android.app.Application
import com.jhowcs.rickandmortyapp.di.AppComponent
import com.jhowcs.rickandmortyapp.di.DaggerAppComponent

class CustomApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(
            this,
            "https://rickandmortyapi.com/api/"
        )
    }
}