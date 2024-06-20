package com.example.a22052024.model

import android.content.Context
import com.example.a22052024.model.repositories.CreditCardRepository

interface AppContainer {
    val creditCardRepository: CreditCardRepository
}

class AppDataContainer(private val context: Context): AppContainer{

    override val creditCardRepository: CreditCardRepository by lazy {
        CreditCardRepository(AppDatabase.getDatabase(context).creditCardDao())
    }
}