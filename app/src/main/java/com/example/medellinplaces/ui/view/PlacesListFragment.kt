package com.example.medellinplaces.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medellinplaces.R
import com.example.medellinplaces.databinding.FragmentPlacesListBinding
import com.example.medellinplaces.ui.CustomPlacesAdapter
import com.example.medellinplaces.ui.viewModel.PlaceViewModel

class PlacesListFragment : Fragment() {

    private var _binding: FragmentPlacesListBinding? = null
    private val binding get() = _binding!!
    private val placeViewModel : PlaceViewModel by viewModels()

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        placeViewModel.onCreate()
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

        //Navigation
        navController = Navigation.findNavController(view)
        binding.buttonMenuImageButtonList.setOnClickListener {
            navController!!.navigate(R.id.action_placesListFragment_to_settingsFragment)
        }

        //RecyclerView feeding
        recyclerViewPlaces.layoutManager = linearLayoutManager

        var customAdapter: CustomPlacesAdapter

        //Observing list of POI's in json online
        placeViewModel.placeModelList.observe(this, Observer {
            customAdapter = CustomPlacesAdapter(requireContext(),
                it, navController)
            recyclerViewPlaces.adapter = customAdapter
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}