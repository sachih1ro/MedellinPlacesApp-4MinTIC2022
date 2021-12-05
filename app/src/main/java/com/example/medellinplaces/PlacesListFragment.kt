package com.example.medellinplaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medellinplaces.utils.Utils
import org.json.JSONException
import org.json.JSONObject

class PlacesListFragment : Fragment() {

    var placeNames: ArrayList<String> = ArrayList()
    var placeDescriptions: ArrayList<String> = ArrayList()
    var placeImageNames: ArrayList<String> = ArrayList()
    var placeScores: ArrayList<String> = ArrayList()
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewPlaces: RecyclerView = view.findViewById(R.id.places_recyclerView)
        val linearLayoutManager = LinearLayoutManager(requireContext().applicationContext)

        navController = Navigation.findNavController(view)
        view.findViewById<ImageButton>(R.id.buttonMenu_imageButton_list).setOnClickListener {
            navController!!.navigate(R.id.action_placesListFragment_to_settingsFragment)
        }

        recyclerViewPlaces.layoutManager = linearLayoutManager

        try {
            val obj = JSONObject(Utils(requireContext()).loadJsonFromAssets(requireContext()
                .applicationContext, "places.json"))
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

        val customAdapter = CustomPlacesAdapter(requireContext(),
            placeNames, placeDescriptions, placeImageNames, placeScores)
        recyclerViewPlaces.adapter = customAdapter

    }

}