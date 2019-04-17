package com.vmarienkov.beers

import android.app.Application

class App : Application() {
    val appModule: AppModule by lazy {
        AppModule(this)
    }
}