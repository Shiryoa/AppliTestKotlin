package fr.wharrgarbl.appliform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.wharrgarbl.appliform.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = PlantRepository()

        repo.updateData{
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

    }


}

