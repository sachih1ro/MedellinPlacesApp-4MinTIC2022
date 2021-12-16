package com.example.medellinplaces.model

import com.example.medellinplaces.network.PlacesService

class PlaceRepository {
    private val api = PlacesService()
    suspend fun getAllPlaces(): List<PlaceModel>{
        val response = api.getPlaces()
        PlaceProvider.places = response
        return response
    }
}