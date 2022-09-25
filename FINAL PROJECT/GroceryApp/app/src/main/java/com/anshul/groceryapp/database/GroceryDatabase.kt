package com.anshul.groceryapp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.vo.Database
import com.anshul.groceryapp.database.entity.GroceryEntities


abstract class GroceryDatabase : RoomDatabase() {
    abstract fun getGroceryDao(): GroceryDao

    companion object {
        @Volatile
        private var instance: GroceryDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                GroceryDatabase::class.java,
                "Grocery.db"
            ).build()
    }
}













