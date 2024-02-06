package fr.wharrgarbl.appliform.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import fr.wharrgarbl.appliform.R

class PlantAdapter :RecyclerView.Adapter<PlantAdapter.ViewHolder>(){

    //boite a composants
    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
    }

    //permet d'injecter le layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal_plant,parent,false)
        return ViewHolder(view)
    }

    //Nombre d'items
    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }
}