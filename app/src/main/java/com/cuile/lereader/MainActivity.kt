package com.cuile.lereader

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { _ ->
            val navController = findNavController(R.id.nav_host_fragment)
            val currentFragmentLabel = navController.currentDestination?.label
            if (getString(R.string.local_fragment_label) == currentFragmentLabel){
                navController.navigate(R.id.action_LocalFragment_to_OnlineFragment)
                fab.setImageResource(R.drawable.ic_home_black_24dp)
            } else if (getString(R.string.online_fragment_label) == currentFragmentLabel) {
                navController.navigateUp()
                fab.setImageResource(R.drawable.ic_add_black_24dp)
            }

        }
    }
}
