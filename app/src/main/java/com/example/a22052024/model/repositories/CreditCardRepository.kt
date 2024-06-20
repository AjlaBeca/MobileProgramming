package com.example.a22052024.model.repositories

import com.example.a22052024.model.daos.CreditCardDao
import com.example.a22052024.model.models.CreditCard
import kotlinx.coroutines.flow.Flow

class CreditCardRepository(private val creditCardDao: CreditCardDao) {

    suspend fun addCreditCard(creditCard: CreditCard) = creditCardDao.addCreditCard(creditCard)

   /* TODO: CREATE A FUNCTION getCreditCard THAT GETS ONE CREDIT CARD*/
    fun getCreditCard(id: Int): Flow<CreditCard?> = creditCardDao.getCreditCard(id)

    fun getCreditCards(): Flow<List<CreditCard>> = creditCardDao.getCreditCards()
}