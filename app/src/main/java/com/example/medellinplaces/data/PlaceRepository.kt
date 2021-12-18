package com.example.medellinplaces.data

import com.example.medellinplaces.data.model.PlaceModel
import com.example.medellinplaces.data.model.PlaceProvider
import com.example.medellinplaces.data.network.PlacesService

class PlaceRepository {
    private val api = PlacesService()
    suspend fun getAllPlaces(): List<PlaceModel>{
        val response = api.getPlaces()
        PlaceProvider.places = response
        return response
    }
}