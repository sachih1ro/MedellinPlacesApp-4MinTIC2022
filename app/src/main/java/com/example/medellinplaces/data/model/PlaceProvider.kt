package com.example.medellinplaces.data.model

class PlaceProvider {
    companion object {

        var places: List<PlaceModel> = emptyList()

        private var actualPlaceId: Int = 0

        fun obtainActualPlaceId(): Int{
            return actualPlaceId
        }

        fun setPlaceId(value: Int) {
            this.actualPlaceId = value
        }

        fun getPlace(position: Int):PlaceModel{
            return places[position]
        }

        fun getTotalPlaces():List<PlaceModel>{
            return places
        }

    }
}