package com.anshul.groceryapp.database

import com.anshul.groceryapp.database.entity.GroceryEntities

class GroceryRepository(private val db: GroceryDatabase) {
    suspend fun insert(items: GroceryEntities) = db.getGroceryDao().insert(items)
    suspend fun delete(items: GroceryEntities) = db.getGroceryDao().delete(items)

    fun getAllItems() = db.getGroceryDao().getAllGroceryItems()
}