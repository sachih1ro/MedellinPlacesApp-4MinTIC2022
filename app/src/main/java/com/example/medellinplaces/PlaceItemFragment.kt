package com.example.medellinplaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PlaceItemFragment : Fragment() {

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<ImageButton>(R.id.buttonMenu_imageButton_item).setOnClickListener {
            navController!!.navigate(R.id.action_placeItemFragment_to_settingsFragment)
        }
    }

}