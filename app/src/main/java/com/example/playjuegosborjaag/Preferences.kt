/**
 * Preferences.kt - Pantalla para la configuración de preferencias del usuario.
 */
package com.example.playjuegosborjaag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Preferences - Permite al usuario seleccionar opciones de preferencia utilizando controles interactivos.
 */
class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preferences)

        // Configura la barra de herramientas
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Referencias a los controles interactivos
        val radioGroup = findViewById<RadioGroup>(R.id.opcion)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        // Configura el botón flotante para mostrar las preferencias seleccionadas
        fab.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                // Si no se selecciona ninguna opción
                Toast.makeText(this, "No has pulsado ninguna opción", Toast.LENGTH_SHORT).show()
            } else {
                // Obtiene la opción seleccionada
                val radioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val seleccionado = radioButton.text.toString()

                // Obtiene valores de SeekBar y RatingBar
                val seek = seekBar.progress
                val ratio = ratingBar.rating

                // Muestra un mensaje con las preferencias seleccionadas
                val message = "Juego: $seleccionado\nPuntuación: $ratio => $seek"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
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