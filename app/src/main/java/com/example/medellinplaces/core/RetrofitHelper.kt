package com.example.medellinplaces.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/sachih1ro/demo4placesmed/").
        addConverterFactory(GsonConverterFactory.create()).build()
    }

}