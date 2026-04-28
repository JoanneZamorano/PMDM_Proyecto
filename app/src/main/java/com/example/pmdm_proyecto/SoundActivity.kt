package com.example.pmdm_proyecto

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class SoundActivity : AppCompatActivity() {
    private var mp: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound)

        //seekBar -> barra sonido
        seekBar = findViewById(R.id.seekBarSonido)

        //botones de efectos
        val btnEspada = findViewById<Button>(R.id.btnEspada)
        val btnFuego = findViewById<Button>(R.id.btnFuego)

        // botones de ambiente
        val btnBosque = findViewById<Button>(R.id.btnBosque)
        val btnMazmorras = findViewById<Button>(R.id.btnMazmorras)

        btnEspada.setOnClickListener { reproducirSonido(R.raw.soundsword) }
        btnFuego.setOnClickListener { reproducirSonido(R.raw.soundfireball) }
        btnBosque.setOnClickListener { reproducirSonido(R.raw.soundforest) }
        btnMazmorras.setOnClickListener { reproducirSonido(R.raw.soundcatacombs) }

        //barra interactiva (poder saltar a un minuto)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mp?.seekTo(progress)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    private fun reproducirSonido(resourceId: Int) {
        // 1.si  hay algo sonando, lo para y libera memoria
        mp?.stop()
        mp?.release()

        // 2. crea el nuevo sonido
        mp = MediaPlayer.create(this, resourceId)
        mp?.start()

        // 3.configura la barra según duración del audio
        mp?.let {
            seekBar.max = it.duration
            actualizarBarra()
        }
    }

    private fun actualizarBarra() {
        mp?.let {
            if (it.isPlaying) {
                seekBar.progress = it.currentPosition
                handler.postDelayed({ actualizarBarra() }, 100) //se actualiza cada x msg para que sea fluido
            }
        }
    }

    //detener el sonido al salir de la pantalla
    override fun onPause() {
        super.onPause()
        if (mp?.isPlaying == true) {
            mp?.pause()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mp?.release()
        mp = null
        handler.removeCallbacksAndMessages(null)
    }
}