package com.example.medellinplaces

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.medellinplaces.databinding.PlacesItemBinding
import com.example.medellinplaces.model.PlaceModel
import com.example.medellinplaces.viewModel.PlaceViewModel

class CustomPlacesAdapter(private var context: Context, private var placesList: List<PlaceModel>,
                          private var navController: NavController? = null
    ):RecyclerView.Adapter<CustomPlacesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CustomPlacesAdapter.MyViewHolder {
        val binding = PlacesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    inner class MyViewHolder(val binding: PlacesItemBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onBindViewHolder(holder: CustomPlacesAdapter.MyViewHolder, position: Int) {
        with(holder){
            with(placesList[position]){
                holder.binding.textViewPlaceName.text = this.placeName
                holder.binding.textViewPlaceDescription.text = this.placeDescription
                holder.binding.textViewScoreValueRV.text = this.placeScore

                val idImageView = context.resources
                    .getIdentifier(this.imageName,"drawable", context.packageName)
                holder.binding.imageViewPlace.setImageResource(idImageView)

                holder.binding.constraintlyItemCard.setOnClickListener{
                    //placeViewModel.changePlaceModelInItemFrag(bindingAdapterPosition)
                    PlaceViewModel().changePlaceid(bindingAdapterPosition)
                    //PlaceViewModel().setPlaceAtPosition(bindingAdapterPosition)
                    //Log.d("cambioID","Cambio es"+PlaceViewModel().obtenerPlaceid().toString())
                    //Log.d("cambioID","Deberia ser pos "+bindingAdapterPosition)
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