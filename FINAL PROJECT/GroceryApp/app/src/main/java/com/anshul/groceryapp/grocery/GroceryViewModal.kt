package com.anshul.groceryapp.grocery

import androidx.lifecycle.ViewModel
import com.anshul.groceryapp.database.GroceryRepository
import com.anshul.groceryapp.database.entity.GroceryEntities
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModal(private val repository: GroceryRepository) : ViewModel() {
    fun insert(items: GroceryEntities) = GlobalScope.launch {
        repository.insert(items)
    }

    fun delete(items: GroceryEntities) = GlobalScope.launch {
        repository.delete(items)
    }

    fun getAllGroceryItems() = repository.getAllItems()
}














