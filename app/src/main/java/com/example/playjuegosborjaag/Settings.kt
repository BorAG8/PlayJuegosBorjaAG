/**
 * Settings.kt - Pantalla de configuración de la aplicación.
 */
package com.example.playjuegosborjaag

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Settings - Permite a los usuarios gestionar la configuración y explorar opciones de navegación.
 */
class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)

        // Configuración de la barra de navegación inferior
        val bottomAppBar: BottomAppBar = findViewById(R.id.bottomAppBar)
        setSupportActionBar(bottomAppBar)

        val bottomNavigationView = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Configuración del botón flotante
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            Toast.makeText(this, "Se desplaza hacia arriba", Toast.LENGTH_SHORT).show()

            // Animación de movimiento hacia arriba
            val moveUp = ObjectAnimator.ofFloat(fab, "translationY", 0f, -200f)
            moveUp.duration = 300
            moveUp.start()

            // Animación de retorno a su posición original
            fab.postDelayed({
                Toast.makeText(this, "Vuelve a su sitio...", Toast.LENGTH_SHORT).show()
                val moveDown = ObjectAnimator.ofFloat(fab, "translationY", -200f, 0f)
                moveDown.duration = 300
                moveDown.start()
            }, 3000)
        }

        // Configuración del grupo de chips
        val chipGroup: ChipGroup = findViewById(R.id.chipGroup)

        val chip1: Chip = findViewById(R.id.chip1)
        val chip2: Chip = findViewById(R.id.chip2)
        val chip3: Chip = findViewById(R.id.chip3)
        val chip4: Chip = findViewById(R.id.chip4)
        val chip5: Chip = findViewById(R.id.chip5)
        val chip6: Chip = findViewById(R.id.chip6)
        val chip7: Chip = findViewById(R.id.chip7)

        // Configura los listeners para los chips
        listOf(chip1, chip2, chip3, chip4, chip5, chip6, chip7).forEach { chip ->
            chip.setOnClickListener {
                if (chip.isChecked) {
                    Toast.makeText(this, "Seleccionado: ${chip.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Configuración del RecyclerView para mostrar géneros
        val generos = listOf(
            "Acción", "Aventura", "Deportes", "Disparos",
            "Estrategia", "Lucha", "Musical", "Rol", "Simulación"
        )

        val recyclerView: RecyclerView = findViewById(R.id.deportes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GenerosAdapter(generos) { genero ->
            Toast.makeText(this, "$genero", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Maneja las acciones seleccionadas en el menú de opciones.
     * @param item Elemento seleccionado del menú.
     * @return Booleano indicando si se manejó la acción.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_search -> true
            R.id.action_add -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Crea el menú de opciones en la barra de navegación inferior.
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_bottom_app, menu)
        return true
    }
}