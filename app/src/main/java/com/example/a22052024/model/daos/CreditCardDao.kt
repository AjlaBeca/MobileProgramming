package com.example.a22052024.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.a22052024.model.models.CreditCard
import kotlinx.coroutines.flow.Flow

@Dao
interface CreditCardDao {

    /*TODO: implement query for getting one credit card by id */
    @Query("SELECT * FROM creditcards WHERE id = :id")
    fun getCreditCard(id: Int): Flow<CreditCard>

    @Query("SELECT * FROM creditcards")
    fun getCreditCards(): Flow<List<CreditCard>>

    @Insert
    suspend fun addCreditCard(card: CreditCard)

}