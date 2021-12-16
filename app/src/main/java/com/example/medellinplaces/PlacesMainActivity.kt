package com.example.medellinplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.medellinplaces.databinding.ActivityPlacesMainBinding

class PlacesMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacesMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}