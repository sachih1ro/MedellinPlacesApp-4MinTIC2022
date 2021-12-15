package com.example.medellinplaces.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.medellinplaces.model.PlaceModel
import com.example.medellinplaces.model.PlaceProvider

class PlaceViewModel: ViewModel() {

    var placeModel = MutableLiveData<PlaceModel>()
    var placeModelActual = MutableLiveData<PlaceModel>()

    fun obtenerPlaceid():Int{
        val currentPlaceId = PlaceProvider.obtainActualPlaceId()
        return currentPlaceId
    }

    fun changePlaceid(id:Int){
        PlaceProvider.setPlaceId(id)
    }

    fun getPlaceAtPosition(pos:Int):PlaceModel{
        return PlaceProvider.getPlace(pos)

    }

    fun setPlaceAtPosition(pos:Int){
        val currentPlace = PlaceProvider.getPlace(pos)
        placeModel.postValue(currentPlace)
    }


}