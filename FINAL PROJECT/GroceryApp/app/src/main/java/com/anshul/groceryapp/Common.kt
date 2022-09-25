package com.anshul.groceryapp

import com.anshul.groceryapp.model.Results
import com.anshul.groceryapp.remote.IGoogleAPIService
import com.anshul.groceryapp.remote.RetrofitClient

const val GOOGLE_API_URL = "https://maps.googleapis.com/"

object Common {
    var currentResult: Results? = null
    val googleApiService: IGoogleAPIService
        get() = RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService::class.java)
}