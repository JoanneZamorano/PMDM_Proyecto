package com.example.pmdm_proyecto

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dado)

        val imgDado = findViewById<ImageView>(R.id.imgDado)
        val txtResultado = findViewById<TextView>(R.id.txtResultadoDado)

        imgDado.setOnClickListener {
            //genera número aleatorio 1-20
            val resultado = (1..20).random()

            when (resultado) {
                1 -> {
                    txtResultado.text = "1\n¡PICIA TOTAL!"
                    txtResultado.setTextColor(Color.parseColor("#F44336")) // Rojo
                }
                20 -> {
                    txtResultado.text = "20\n¡CRÍTICO!"
                    txtResultado.setTextColor(Color.parseColor("#FFD700")) // Dorado/Amarillo
                }
                else -> {
                    txtResultado.text = "Has sacado un\n$resultado"
                    txtResultado.setTextColor(Color.WHITE)
                }
            }

            //animación
            imgDado.animate().rotationBy(360f).setDuration(500).start()
        }
    }
}