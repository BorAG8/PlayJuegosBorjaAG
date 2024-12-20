/**
 * NewPlayer.kt - Pantalla para la creación de un nuevo perfil de jugador.
 */
package com.example.playjuegosborjaag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * NewPlayer - Permite al usuario crear un nuevo perfil de jugador completando un formulario.
 */
class NewPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_player)

        // Configura la barra de herramientas
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configuración del Spinner
        val spinner: Spinner = findViewById(R.id.spinner)
        val editTextTelefono: EditText = findViewById(R.id.editTextTelefono)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Configura el listener del Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Obtiene la opción seleccionada y la asigna al campo de texto
                val selectedOption = parent.getItemAtPosition(position).toString()
                editTextTelefono.setText(selectedOption)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No se realiza ninguna acción cuando no se selecciona nada
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