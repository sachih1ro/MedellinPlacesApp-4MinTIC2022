package com.example.medellinplaces.data.model

import com.google.gson.annotations.SerializedName

data class PlaceModel(@SerializedName("name") val placeName: String,
                      @SerializedName("description") val placeDescription: String,
                      @SerializedName("image") val imageName: String,
                      @SerializedName("score") val placeScore: String,
                      @SerializedName("latitude") val placeLatitude: String,
                      @SerializedName("longitude") val placeLongitude: String) {
}
