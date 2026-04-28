package com.example.pmdm_proyecto

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        //Personajes
        findViewById<ImageView>(R.id.imgHeroe1).setOnClickListener {
            Toast.makeText(this, "Has seleccionado al Guerrero", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.imgHeroe2).setOnClickListener {
            Toast.makeText(this, "Has seleccionado al Orco", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.imgHeroe3).setOnClickListener {
            Toast.makeText(this, "Has seleccionado al Orco", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.imgVillano1).setOnClickListener {
            Toast.makeText(this, "Has seleccionado al Orco", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.imgVillano2).setOnClickListener {
            Toast.makeText(this, "Has seleccionado al Orco", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.imgVillano3).setOnClickListener {
            Toast.makeText(this, "Has seleccionado al Orco", Toast.LENGTH_SHORT).show()
        }

        //botón de carga de los malos
        val btnCargar = findViewById<Button>(R.id.btnCargarMas)
        val seccionMalos = findViewById<LinearLayout>(R.id.layoutMalos)

        btnCargar.setOnClickListener {

            seccionMalos.visibility = View.VISIBLE // hace visible la sección oculta
            btnCargar.visibility = View.GONE  // cculta el botón porque ya no hace falta

            Toast.makeText(this, "¡OH NO! lA MAZMORRA ESTÁ MALDITA", Toast.LENGTH_SHORT).show()
        }

    }
}