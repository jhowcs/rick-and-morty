package com.jhowcs.rickandmortyapp.di

import android.content.Context
import com.jhowcs.rickandmortyapp.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance baseUrl: String): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}