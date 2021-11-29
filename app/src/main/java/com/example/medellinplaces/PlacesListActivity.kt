package com.example.medellinplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medellinplaces.utils.Utils
import org.json.JSONException
import org.json.JSONObject

class PlacesListActivity : AppCompatActivity() {

    var placeNames: ArrayList<String> = ArrayList()
    var placeDescriptions: ArrayList<String> = ArrayList()
    var placeImageNames: ArrayList<String> = ArrayList()
    var placeScores: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places_list)

        val recyclerViewPlaces: RecyclerView = findViewById(R.id.places_recyclerView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)

        recyclerViewPlaces.layoutManager = linearLayoutManager

        try {
            val obj = JSONObject(Utils(this).loadJsonFromAssets(applicationContext, "places.json"))
            val placesArray = obj.getJSONArray("places")
            for (i in 0 until placesArray.length()) {
                val placeInfo = placesArray.getJSONObject(i)
                placeNames.add(placeInfo.getString("name"))
                placeDescriptions.add(placeInfo.getString("description"))
                placeImageNames.add(placeInfo.getString("image"))
                placeScores.add(placeInfo.getString("score"))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val customAdapter = CustomPlacesAdapter(this@PlacesListActivity, placeNames, placeDescriptions, placeImageNames, placeScores)
        recyclerViewPlaces.adapter = customAdapter


    }


}