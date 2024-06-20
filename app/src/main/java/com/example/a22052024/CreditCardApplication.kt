package com.example.a22052024

import android.app.Application
import com.example.a22052024.model.AppContainer
import com.example.a22052024.model.AppDataContainer

class CreditCardApplication: Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }

}