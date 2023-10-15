package com.simonllano.fragmentos.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.simonllano.fragmentos.databinding.ActivityMainBinding
import com.simonllano.fragmentos.ui.bottom.BottomNavigationActivity
import com.simonllano.fragmentos.ui.masterdetail.MasterDetailActivity
import com.simonllano.fragmentos.ui.navdrawer.NavigationDrawerActivity
import com.simonllano.fragmentos.ui.tabbed.TabbedActivity



class MainActivity : AppCompatActivity() {

    private lateinit var fragmentosBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        fragmentosBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = fragmentosBinding.root
        setContentView(view)


        fragmentosBinding.bottomNavButton.setOnClickListener {//Aca se envia la orden para abrir la actividad
            val intent = Intent(
                this,
                BottomNavigationActivity::class.java
            )
            startActivity(intent)
        }
        fragmentosBinding.navDrawerButton.setOnClickListener {//Aca se envia la orden para abrir la actividad
            val intent = Intent(
                this,
                NavigationDrawerActivity::class.java
            ) //donde se encontrara el perimetro del cuadrado
            startActivity(intent)
        }
        fragmentosBinding.swipeTabsButton.setOnClickListener {
            val intent = Intent(this, TabbedActivity::class.java)
            startActivity(intent)
        }

        fragmentosBinding.masterDetailButton.setOnClickListener {//Aca se envia la orden para abrir la actividad
            val intent = Intent(
                this,
                MasterDetailActivity::class.java
            ) //donde se encontrara el perimetro del cuadrado
            startActivity(intent)
        }

    }
}

