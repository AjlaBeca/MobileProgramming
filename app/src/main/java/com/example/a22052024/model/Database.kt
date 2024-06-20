package com.example.a22052024.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a22052024.model.daos.CreditCardDao
import com.example.a22052024.model.models.CreditCard

@Database(entities = [CreditCard::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun creditCardDao(): CreditCardDao

    companion object{
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "APPDatabase")
                    .build().also { Instance = it }
            }
        }

    }
}