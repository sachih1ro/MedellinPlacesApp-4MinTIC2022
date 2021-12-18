package com.example.medellinplaces.data.network

import com.example.medellinplaces.data.model.PlaceModel
import com.example.medellinplaces.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlacesService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getPlaces(): List<PlaceModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PlacesApiClient::class.java).getAllPlaces()
            response.body() ?: emptyList()
        }
    }

}