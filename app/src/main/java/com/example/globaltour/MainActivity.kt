package com.example.globaltour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var toolbar        : MaterialToolbar
    private lateinit var navController  : NavController
    private lateinit var navigationview : NavigationView
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Views
        toolbar         = findViewById(R.id.activity_main_toolbar)
        navigationview = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)

        // Get NavHostFragment and NavController
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        navController   = navHostFrag.navController

        //define appbar configuration
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)


        //connect tool bar with navgation controller
        toolbar.setupWithNavController(navController,appBarConfiguration)
       //connect navigation view with nav controller

        navigationview.setupWithNavController(navController)




    }

    override fun onBackPressed() {
        if (drawerLayout.isOpen)
        {
            drawerLayout.close()
        }else{
            super.onBackPressed()
        }


    }
}