package com.example.medellinplaces.data.network

import com.example.medellinplaces.data.model.PlaceModel
import retrofit2.Response
import retrofit2.http.GET

interface PlacesApiClient {
    @GET("places")
    suspend fun getAllPlaces(): Response<List<PlaceModel>>
}