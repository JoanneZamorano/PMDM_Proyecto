import android.app.Activity
import android.widget.Button
import com.example.pmdm_proyecto.R
fun Activity.BotonVolver() {
    val btnVolver = findViewById<Button>(R.id.btnVolver)
    btnVolver?.setOnClickListener {
        finish()
    }
}