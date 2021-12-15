package com.example.medellinplaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medellinplaces.utils.Utils
import org.json.JSONException
import org.json.JSONObject
import com.example.medellinplaces.databinding.FragmentPlacesListBinding
import com.example.medellinplaces.model.PlaceModel
import com.example.medellinplaces.model.PlaceProvider
import com.example.medellinplaces.viewModel.PlaceViewModel

class PlacesListFragment : Fragment() {

    private var _binding: FragmentPlacesListBinding? = null
    private val binding get() = _binding!!
    private val placeViewModel : PlaceViewModel by viewModels()

    var listPlaces: ArrayList<PlaceModel> = ArrayList()
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlacesListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewPlaces: RecyclerView = binding.placesRecyclerView
        val linearLayoutManager = LinearLayoutManager(requireContext().applicationContext)

        navController = Navigation.findNavController(view)
        binding.buttonMenuImageButtonList.setOnClickListener {
            navController!!.navigate(R.id.action_placesListFragment_to_settingsFragment)
        }

        recyclerViewPlaces.layoutManager = linearLayoutManager

        try {
            val obj = JSONObject(Utils(requireContext()).loadJsonFromAssets(requireContext()
                .applicationContext, "places.json"))
            val placesArray = obj.getJSONArray("places")
            for (i in 0 until placesArray.length()) {
                val placeInfo = placesArray.getJSONObject(i)
                listPlaces.add(PlaceModel(placeInfo.getString("name"),
                    placeInfo.getString("description"),
                    placeInfo.getString("image"),
                    placeInfo.getString("score")))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        //val customAdapter = CustomPlacesAdapter(requireContext(),
        //    listPlaces)

        val customAdapter = CustomPlacesAdapter(requireContext(),
           PlaceProvider.places, navController)

        recyclerViewPlaces.adapter = customAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}