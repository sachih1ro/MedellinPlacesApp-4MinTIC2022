package com.example.medellinplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.medellinplaces.databinding.ActivityPlacesMainBinding
import com.example.medellinplaces.viewModel.PlaceViewModel

class PlacesMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacesMainBinding

    private val placeViewModel: PlaceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}