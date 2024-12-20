/**
 * MainActivity.kt - Punto de entrada principal de la aplicación.
 */
package com.example.playjuegosborjaag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * MainActivity - Menú principal de la aplicación. Proporciona navegación a diferentes pantallas mediante botones.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configura el botón para lanzar la actividad de Nuevo Jugador
        val jugador: Button = findViewById(R.id.botonNP)
        jugador.setOnClickListener { lanzarNewPlayer() }

        // Configura el botón para lanzar la actividad de Preferencias
        val preferencias: Button = findViewById(R.id.botonPR)
        preferencias.setOnClickListener { lanzarPreferences() }

        // Configura el botón para lanzar la actividad de Juegos
        val gameplay: Button = findViewById(R.id.botonPlay)
        gameplay.setOnClickListener { lanzarPlay() }

        // Configura el botón para lanzar la actividad Acerca de
        val about: Button = findViewById(R.id.botonAbout)
        about.setOnClickListener { lanzarAbout() }

        // Configura la barra de herramientas
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    /**
     * Lanza la actividad de Nuevo Jugador.
     */
    fun lanzarNewPlayer() {
        val i = Intent(this, NewPlayer::class.java)
        startActivity(i)
    }

    /**
     * Lanza la actividad de Preferencias.
     */
    fun lanzarPreferences() {
        val i = Intent(this, Preferences::class.java)
        startActivity(i)
    }

    /**
     * Lanza la actividad de Juegos.
     */
    fun lanzarPlay() {
        val i = Intent(this, Games::class.java)
        startActivity(i)
    }

    /**
     * Lanza la actividad Acerca de.
     */
    fun lanzarAbout() {
        val i = Intent(this, About::class.java)
        startActivity(i)
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