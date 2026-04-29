package com.example.pmdm_proyecto
import BotonVolver
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_list))

        //boton volver
        BotonVolver()

        val recycler = findViewById<RecyclerView>(R.id.recyclerVideos)
        recycler.layoutManager = LinearLayoutManager(this)

        var lista = listOf(
            Video ("Introducción a D&D", R.drawable.bookrole, R.raw.videoplayback),
            Video ("Catacumbas", R.drawable.bookrole, R.raw.catacumbas),
            Video ("Bosque", R.drawable.bookrole, R.raw.forestvideo),
        )


        val adapter = VideoAdapter(lista){video ->
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("video", video.video)
            startActivity(intent)
        }

        recycler.adapter = adapter

    }
}