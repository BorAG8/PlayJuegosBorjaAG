package com.example.playjuegosborjaag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

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

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewGeneros)

        val personas = nombres.zip(horas).zip(fotos) { (nombre, horas), foto ->
            Persona(nombre, horas, foto)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PersonaAdapter(personas) { nombre ->
            Toast.makeText(this, "$nombre", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_search -> {
                val intent = Intent(this, Settings::class.java)
                startActivity(intent)
                return true
            }
            (R.id.action_settings) -> {return true}
            (R.id.action_add) -> {return true}
            else -> {return super.onOptionsItemSelected(item)} }
    }
}