package fr.wharrgarbl.appliform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.wharrgarbl.appliform.MainActivity
import fr.wharrgarbl.appliform.PlantModel
import fr.wharrgarbl.appliform.R
import fr.wharrgarbl.appliform.adapter.PlantAdapter
import fr.wharrgarbl.appliform.adapter.PlantItemDecoration


class HomeFragment(
    private val context: MainActivity
) : Fragment() {

    override fun onCreateView (inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_home,container,false)

        //liste stockage plante
        val plantList = arrayListOf<PlantModel>()

        //1st plant
        plantList.add(
            PlantModel(
            "Pissenlit",
            "jaune soleil",
            "https://cdn.pixabay.com/photo/2017/04/27/20/17/dandelion-2266558_1280.jpg",
            false
            )
        )

        //2nd plant
        plantList.add(
            PlantModel(
                "Rose",
                "epines mais romantique",
                "https://cdn.pixabay.com/photo/2014/04/10/11/24/rose-320868_1280.jpg",
                false
            )
        )

        //3nd plant
        plantList.add(
            PlantModel(
                "Tournesol",
                "gros machin",
                "https://cdn.pixabay.com/photo/2016/08/28/23/18/sunflower-1627179_960_720.jpg",
                false
            )
        )

        //4nd plant
        plantList.add(
            PlantModel(
                "Coquelicot",
                "beau mais pousse sur des morts",
                "https://cdn.pixabay.com/photo/2020/06/13/05/52/poppy-5292815_1280.jpg",
                false
            )
        )

        //recup recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context,plantList,R.layout.item_horizontal_plant)

        //recuple2ndrecyclerview
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context,plantList,R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }
}