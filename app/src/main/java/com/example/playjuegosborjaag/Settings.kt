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

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)

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


        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {

            Toast.makeText(this, "Se desplaza hacia arriba", Toast.LENGTH_SHORT).show()

            val moveUp = ObjectAnimator.ofFloat(fab, "translationY", 0f, -200f)
            moveUp.duration = 300
            moveUp.start()

            fab.postDelayed({
                Toast.makeText(this, "Vuelve a su sitio...", Toast.LENGTH_SHORT).show()
                val moveDown = ObjectAnimator.ofFloat(fab, "translationY", -200f, 0f)
                moveDown.duration = 300
                moveDown.start()
            }, 3000)
        }
        val chipGroup: ChipGroup = findViewById(R.id.chipGroup)

        val chip1: Chip = findViewById(R.id.chip1)
        val chip2: Chip = findViewById(R.id.chip2)
        val chip3: Chip = findViewById(R.id.chip3)
        val chip4: Chip = findViewById(R.id.chip4)
        val chip5: Chip = findViewById(R.id.chip5)
        val chip6: Chip = findViewById(R.id.chip6)
        val chip7: Chip = findViewById(R.id.chip7)

        chip1.setOnClickListener {
            if (chip1.isChecked) {
                Toast.makeText(this, "Seleccionado: ${chip1.text}", Toast.LENGTH_SHORT).show()
            }
        }
        chip2.setOnClickListener {
            if (chip2.isChecked) {
                Toast.makeText(this, "Seleccionado: ${chip2.text}", Toast.LENGTH_SHORT).show()
            }
        }
        chip3.setOnClickListener {
            if (chip3.isChecked) {
                Toast.makeText(this, "Seleccionado: ${chip3.text}", Toast.LENGTH_SHORT).show()
            }
        }
        chip4.setOnClickListener {
            if (chip4.isChecked) {
                Toast.makeText(this, "Seleccionado: ${chip4.text}", Toast.LENGTH_SHORT).show()
            }
        }
        chip5.setOnClickListener {
            if (chip5.isChecked) {
                Toast.makeText(this, "Seleccionado: ${chip5.text}", Toast.LENGTH_SHORT).show()
            }
        }
        chip6.setOnClickListener {
            if (chip6.isChecked) {
                Toast.makeText(this, "Seleccionado: ${chip6.text}", Toast.LENGTH_SHORT).show()
            }
        }
        chip7.setOnClickListener {
            if (chip7.isChecked) {
                Toast.makeText(this, "Seleccionado: ${chip7.text}", Toast.LENGTH_SHORT).show()
            }
        }

        val generos = listOf(
            "Acción", "Aventura", "Deportes", "Disparos",
            "Estrategia", "Lucha", "Musical", "Rol", "Simulación"
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewGeneros)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GenerosAdapter(generos) { genero ->
            Toast.makeText(this,  "$genero", Toast.LENGTH_SHORT).show()
        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_search -> {
                true
            }
            R.id.action_add -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_bottom_app, menu)
        return true
    }

}