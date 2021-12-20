package com.example.medellinplaces.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.medellinplaces.databinding.ActivityPlacesMainBinding

class PlacesMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacesMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}