package com.example.playjuegosborjaag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val jugador: Button = findViewById(R.id.botonNP)
        jugador.setOnClickListener { lanzarNewPlayer() }

        val preferencias: Button = findViewById(R.id.botonPR)
        preferencias.setOnClickListener { lanzarPreferences() }

        val gameplay: Button = findViewById(R.id.botonPlay)
        gameplay.setOnClickListener { lanzarPlay() }

        val about: Button = findViewById(R.id.botonAbout)
        about.setOnClickListener { lanzarAbout() }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    fun lanzarNewPlayer() {
        val i = Intent(this, NewPlayer::class.java)
        startActivity(i)
    }
    fun lanzarPreferences() {
        val i = Intent(this, Preferences::class.java)
        startActivity(i)
    }
    fun lanzarPlay() {
        val i = Intent(this, Games::class.java)
        startActivity(i)
    }

    fun lanzarAbout() {
        val i = Intent(this, About::class.java)
        startActivity(i)
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