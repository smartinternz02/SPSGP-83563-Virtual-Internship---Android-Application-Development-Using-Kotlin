package com.anshul.groceryapp.grocery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anshul.groceryapp.database.GroceryRepository

class GroceryViewModalFactory(private val repository: GroceryRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GroceryViewModal(repository) as T
    }
}