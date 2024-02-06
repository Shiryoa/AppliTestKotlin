package fr.wharrgarbl.appliform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.wharrgarbl.appliform.R
import fr.wharrgarbl.appliform.adapter.PlantAdapter


class HomeFragment : Fragment() {

    override fun onCreateView (inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_home,container,false)

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter()
        return view
    }
}