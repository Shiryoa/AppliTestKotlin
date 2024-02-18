package fr.wharrgarbl.appliform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.wharrgarbl.appliform.MainActivity
import fr.wharrgarbl.appliform.PlantRepository.Singleton.plantList
import fr.wharrgarbl.appliform.R
import fr.wharrgarbl.appliform.adapter.PlantAdapter
import fr.wharrgarbl.appliform.adapter.PlantItemDecoration


class HomeFragment(
    private val context: MainActivity
) : Fragment() {

    override fun onCreateView (inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_home,container,false)


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