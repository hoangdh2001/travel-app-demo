package com.example.travelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flaviofaria.kenburnsview.KenBurnsView
import com.squareup.picasso.Picasso

class TravelLocationsAdapter(
    private val travelLocations: List<TravelLocation>
): RecyclerView.Adapter<TravelLocationsAdapter.TravelLocationsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelLocationsViewHolder {
        val adapter = LayoutInflater.from(parent.context).inflate(R.layout.item_container, parent, false)
        return TravelLocationsViewHolder(adapter)
    }

    override fun onBindViewHolder(holder: TravelLocationsViewHolder, position: Int) {
        val travelLocation = travelLocations[position]
        Picasso.get().load(travelLocation.imageUrl).into(holder.kbvLocation)
        holder.textTitle.text = travelLocation.title
        holder.textLocation.text = travelLocation.location
        holder.textStarRating.text = travelLocation.starRating.toString()
    }

    override fun getItemCount(): Int = travelLocations.size

    class TravelLocationsViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val kbvLocation: KenBurnsView = view!!.findViewById(R.id.kbv_location)
        val textTitle: TextView = view!!.findViewById(R.id.text_title)
        val textLocation: TextView = view!!.findViewById(R.id.text_location)
        val textStarRating: TextView = view!!.findViewById(R.id.text_star_rating)
    }

}