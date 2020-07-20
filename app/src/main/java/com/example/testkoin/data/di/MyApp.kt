package com.example.testkoin.data.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }


    open fun configureDi() = startKoin {
        androidContext(this@MyApp)
        modules(listOf(createModule))
    }
}