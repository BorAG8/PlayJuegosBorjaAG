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
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Deportes : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DeporteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_deportes)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val deportes = listOf(
            Deporte("Fútbol", R.drawable.futbol),
            Deporte("Baloncesto", R.drawable.baloncesto),
            Deporte("Natación", R.drawable.natacion),
            Deporte("Tenis", R.drawable.tenis),
            Deporte("Golf", R.drawable.golf),
            Deporte("Beisbol", R.drawable.beisbol),
            Deporte("Ciclismo", R.drawable.ciclismo),
            Deporte("Hipica", R.drawable.hipica),
            Deporte("Pinpon", R.drawable.pinpon)
        )

        recyclerView = findViewById(R.id.deportes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DeporteAdapter(deportes)
        recyclerView.adapter = adapter

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val seleccionados = adapter.getDeportesSeleccionados()
            val nombresSeleccionados = seleccionados.joinToString(", ") { it.nombre }

            if (nombresSeleccionados.isNotEmpty()) {
                Toast.makeText(this, "Has elegido -> $nombresSeleccionados", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No has seleccionado ningún deporte", Toast.LENGTH_SHORT).show()
            }
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
            R.id.action_add -> {
                val intent = Intent(this, Deportes::class.java)
                startActivity(intent)
                return true
            }
            else -> {return super.onOptionsItemSelected(item)} }
    }
}