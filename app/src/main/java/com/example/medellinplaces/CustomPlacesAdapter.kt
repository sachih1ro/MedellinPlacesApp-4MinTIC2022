package com.example.medellinplaces

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomPlacesAdapter(
    private var context: Context,
    private var placeName: ArrayList<String>,
    private val placeDescription: ArrayList<String>,
    private val placeImageName: ArrayList<String>,
    private val placeScore: ArrayList<String>,
    ):RecyclerView.Adapter<CustomPlacesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CustomPlacesAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.places_item, parent, false)
        return MyViewHolder(view)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var placeNameTextView = itemView.findViewById<TextView>(R.id.textView_placeName) as TextView
        var placeDescriptionTextView = itemView.findViewById<TextView>(R.id.textView_placeDescription) as TextView
        var placeImageImageView = itemView.findViewById<ImageView>(R.id.imageView_place) as ImageView
        var placeScoreTextView = itemView.findViewById<TextView>(R.id.textView_scoreValueRV) as TextView
    }

    override fun onBindViewHolder(holder: CustomPlacesAdapter.MyViewHolder, position: Int) {
        holder.placeNameTextView.text = placeName[position]
        holder.placeDescriptionTextView.text = placeDescription[position]
        val idImageView = context.resources
            .getIdentifier(placeImageName[position],"drawable", context.packageName)
        holder.placeImageImageView.setImageResource(idImageView)
        holder.placeScoreTextView.text = placeScore[position]
        holder.itemView.setOnClickListener {
            Toast.makeText(context, placeName[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return placeName.size
    }

}