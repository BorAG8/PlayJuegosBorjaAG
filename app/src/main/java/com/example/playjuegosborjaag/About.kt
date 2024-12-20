/**
 * About.kt - Actividad que muestra información sobre los jugadores y sus estadísticas.
 */
package com.example.playjuegosborjaag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * About - Pantalla que lista jugadores con sus nombres, horas jugadas y fotos.
 */
class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        // Configura la barra de herramientas
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Datos de jugadores
        val nombres = listOf(
            "María Mata", "Antonio Sanz", "Carlos", "Berta",
            "Héctor Campos", "Ismael", "Jesus Fernandez", "Cristina"
        )

        val horas = listOf(
            "2014", "1890", "967", "945",
            "879", "678", "1285", "572"
        )

        val fotos = listOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
            R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8
        )

        // Configuración del RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.deportes)

        // Combinación de datos en una lista de objetos Persona
        val personas = nombres.zip(horas).zip(fotos) { (nombre, horas), foto ->
            Persona(nombre, horas, foto)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PersonaAdapter(personas) { nombre ->
            Toast.makeText(this, "$nombre", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Crea el menú de opciones en la barra de herramientas.
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /**
     * Maneja las acciones seleccionadas en el menú de opciones.
     * @param item Elemento seleccionado del menú.
     * @return Booleano indicando si se manejó la acción.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                val intent = Intent(this, Settings::class.java)
                startActivity(intent)
                true
            }
            R.id.action_settings -> true
            R.id.action_add -> {
                val intent = Intent(this, Deportes::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}