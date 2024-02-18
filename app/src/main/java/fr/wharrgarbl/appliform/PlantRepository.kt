package fr.wharrgarbl.appliform

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.wharrgarbl.appliform.PlantRepository.Singleton.databaseRef
import fr.wharrgarbl.appliform.PlantRepository.Singleton.plantList

class PlantRepository {

    object Singleton {

        // se connecter a la ref "plants"
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")

        //créer une list que va contenir nos plantes
        val plantList = arrayListOf<PlantModel>()

    }

    fun updateData(callback : () -> Unit){
        databaseRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                plantList.clear()
                for (ds in snapshot.children) {
                    val plant = ds.getValue(PlantModel::class.java)

                    if (plant != null) {
                        plantList.add(plant)
                    }
                }
                callback()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    fun updatePlant(plant:PlantModel){
        databaseRef.child(plant.id).setValue(plant)
    }

}