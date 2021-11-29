package com.example.medellinplaces

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlaceItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_item)

        var placeNameTextView = findViewById<TextView>(R.id.textView_placeName_item) as TextView
        var placeDescriptionTextView = findViewById<TextView>(R.id.textView_placeDescription_item) as TextView
        var placeImageImageView = findViewById<ImageView>(R.id.imageView_placeImage_item) as ImageView
        var placeScoreTextView = findViewById<TextView>(R.id.textView_scoreValue_item) as TextView

        var bundle :Bundle ?= intent.extras
        var placeName = bundle?.getString("placeName")
        var placeDescription = bundle?.getString("placeDescription")
        var placeImageName = bundle?.getString("placeImageName")
        var placeScore = bundle?.getString("placeScore")

        placeNameTextView.text = placeName
        placeDescriptionTextView.text = placeDescription
        val idImageView = this.resources
            .getIdentifier(placeImageName,"drawable", this.packageName)
        placeImageImageView.setImageResource(idImageView)
        placeScoreTextView.text = placeScore


    }
}