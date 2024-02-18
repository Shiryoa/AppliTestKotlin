package fr.wharrgarbl.appliform

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import fr.wharrgarbl.appliform.adapter.PlantAdapter

class PlantPopup(private val adapter : PlantAdapter,
private val currentPlant: PlantModel) : Dialog(adapter.context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_plant_details)
        setupComponents()
    }

    private fun setupComponents() {
        val plantImage = findViewById<ImageView>(R.id.image_item)
        Glide.with(adapter.context).load(Uri.parse(currentPlant.imageUrl)).into(plantImage)

        findViewById<TextView>(R.id.popup_plant_name).text = currentPlant.name

        findViewById<TextView>(R.id.popup_plant_description_subtitle).text = currentPlant.description
    }
}