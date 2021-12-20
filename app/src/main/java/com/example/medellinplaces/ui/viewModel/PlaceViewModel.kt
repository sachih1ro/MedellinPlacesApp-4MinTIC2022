package com.example.medellinplaces.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medellinplaces.domain.GetPlacesUseCase
import com.example.medellinplaces.data.model.PlaceModel
import com.example.medellinplaces.data.model.PlaceProvider
import kotlinx.coroutines.launch

class PlaceViewModel: ViewModel() {

    var placeModelList = MutableLiveData<List<PlaceModel>>()
    //var placeModelInItemFrag = MutableLiveData<PlaceModel>()

    var getPlacesUseCase = GetPlacesUseCase()

    fun onCreate(){
        viewModelScope.launch {
            val result = getPlacesUseCase()

            if (!result.isNullOrEmpty()){
                placeModelList.postValue(result)
            }
        }
    }

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

    /*
    fun setPlaceAtPosition(pos:Int){
        val currentPlace = PlaceProvider.getPlace(pos)
        placeModelInItemFrag.postValue(currentPlace)
    }
     */

    fun getAllPlaces():List<PlaceModel>{
        return PlaceProvider.getTotalPlaces()
    }


}