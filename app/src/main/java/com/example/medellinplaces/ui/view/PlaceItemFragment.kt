package com.example.medellinplaces.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.medellinplaces.databinding.FragmentPlaceItemBinding
import com.example.medellinplaces.ui.viewModel.PlaceViewModel
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentTransaction
import com.example.medellinplaces.R
import com.example.medellinplaces.data.model.PlaceModel
import com.squareup.picasso.Picasso

class PlaceItemFragment : Fragment() {

    var navController: NavController? = null
    private var _binding: FragmentPlaceItemBinding? = null
    private val binding get() = _binding!!
    private val placeViewModel: PlaceViewModel by viewModels()

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
        _binding = FragmentPlaceItemBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Child fragment creation creation for display Map
        val childFragment: Fragment = MapsFragment()
        val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
        transaction.replace(binding.fragmentContainer4map.id, childFragment).commit()

        //Elements load (text and image)
        val placeModelSelected : PlaceModel = placeViewModel.
            getPlaceAtPosition(placeViewModel.obtenerPlaceid())
        binding.textViewPlaceNameItem.text = placeModelSelected.placeName
        binding.textViewPlaceDescriptionItem.text = placeModelSelected.placeDescription
        binding.textViewScoreValueItem.text = placeModelSelected.placeScore
        Picasso.get().load(placeModelSelected.imageName).into(binding.imageViewPlaceImageItem)

        //Intent for open location on Google Maps
        binding.buttonShowInGoogleMaps.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:"+
                    placeModelSelected.placeLatitude
                    +","+
                    placeModelSelected.placeLongitude
                    +"?q="+placeModelSelected.placeName)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            mapIntent.resolveActivity(activity!!.packageManager)?.let {
                startActivity(mapIntent)
            }
        }

        //Navigation
        navController = Navigation.findNavController(view)
        binding.buttonMenuImageButtonItem.setOnClickListener {
            navController!!.navigate(R.id.action_placeItemFragment_to_settingsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}