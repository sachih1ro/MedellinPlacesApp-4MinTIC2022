package com.example.medellinplaces.model

import com.google.gson.annotations.SerializedName

data class PlaceModel(@SerializedName("name") val placeName: String,
                      @SerializedName("description") val placeDescription: String,
                      @SerializedName("image") val imageName: String,
                      @SerializedName("score") val placeScore: String,
                      @SerializedName("latitude") val placeLatitude: String,
                      @SerializedName("longitude") val placeLongitude: String) {
}

/*
data class PlaceModel(val placeName: String,
                      val placeDescription: String,
                      val imageName: String,
                      val placeScore: String) {

}

 */