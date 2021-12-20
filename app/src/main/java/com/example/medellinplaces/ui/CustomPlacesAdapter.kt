package com.example.medellinplaces.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.medellinplaces.R
import com.example.medellinplaces.databinding.PlacesItemBinding
import com.example.medellinplaces.data.model.PlaceModel
import com.example.medellinplaces.ui.viewModel.PlaceViewModel
import com.squareup.picasso.Picasso

class CustomPlacesAdapter(private var context: Context, private var placesList: List<PlaceModel>,
                          private var navController: NavController? = null
    ):RecyclerView.Adapter<CustomPlacesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {
        val binding = PlacesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    inner class MyViewHolder(val binding: PlacesItemBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder){
            with(placesList[position]){

                //Elements load (text and image)
                holder.binding.textViewPlaceName.text = this.placeName
                holder.binding.textViewPlaceDescription.text = this.placeDescription
                holder.binding.textViewScoreValueRV.text = this.placeScore
                Picasso.get().load(this.imageName).into(holder.binding.imageViewPlace)

                //Button for open PlacesItemFragment
                holder.binding.constraintlyItemCard.setOnClickListener{
                    //placeViewModel.changePlaceModelInItemFrag(bindingAdapterPosition)
                    PlaceViewModel().changePlaceid(bindingAdapterPosition)
                    navController = Navigation.findNavController(holder.itemView)
                    navController!!.navigate(R.id.action_placesListFragment_to_placeItemFragment)
                }

            }
        }

    }

    override fun getItemCount(): Int {
        return placesList.size
    }

}