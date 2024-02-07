package fr.wharrgarbl.appliform.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.wharrgarbl.appliform.MainActivity
import fr.wharrgarbl.appliform.PlantModel
import fr.wharrgarbl.appliform.R

class PlantAdapter(
    private val context: MainActivity,
    private val plantList: List<PlantModel>,
    private val layoutId: Int)
    :RecyclerView.Adapter<PlantAdapter.ViewHolder>(){

    //boite a composants
    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById(R.id.name_item)
        val plantDescription:TextView? = view.findViewById(R.id.descr_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
    }

    //permet d'injecter le layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId,parent,false)
        return ViewHolder(view)
    }

    //Nombre d'items
    override fun getItemCount(): Int = plantList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //recup info de la plante
        val currentPlant = plantList[position]

        //use glide pour recup l'image
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

        //mettre a jour le nom de la plante
        holder.plantName?.text = currentPlant.name

        //mettre a jour la descde la plante
        holder.plantDescription?.text = currentPlant.description

        //verif si plant liked
        if(currentPlant.liked){
            holder.starIcon.setImageResource(R.drawable.ic_star)
        } else {
            holder.starIcon.setImageResource(R.drawable.ic_unstar)
        }
    }
}