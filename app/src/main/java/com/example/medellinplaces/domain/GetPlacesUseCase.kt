package com.example.medellinplaces.domain

import com.example.medellinplaces.model.PlaceModel
import com.example.medellinplaces.model.PlaceRepository

class GetPlacesUseCase {
    private val repository = PlaceRepository()
    suspend operator fun invoke():List<PlaceModel> = repository.getAllPlaces()
}