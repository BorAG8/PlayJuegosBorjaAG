package com.example.playjuegosborjaag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Games : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_games)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val checkAvion: CheckBox = findViewById(R.id.checkAvion)
        val checkBirds: CheckBox = findViewById(R.id.checkBirds)
        val checkDragon: CheckBox = findViewById(R.id.checkDragon)
        val checkHill: CheckBox = findViewById(R.id.checkHill)
        val checkJump: CheckBox = findViewById(R.id.checkJump)
        val checkSoccer: CheckBox = findViewById(R.id.checkSoccer)
        val checkRadiant: CheckBox = findViewById(R.id.checkRadiant)

        val fab: FloatingActionButton = findViewById(R.id.floatingActionButton)

        fab.setOnClickListener {
            val selectedGames = mutableListOf<String>()

            if (checkAvion.isChecked) selectedGames.add(checkAvion.text.toString())
            if (checkBirds.isChecked) selectedGames.add(checkBirds.text.toString())
            if (checkDragon.isChecked) selectedGames.add(checkDragon.text.toString())
            if (checkHill.isChecked) selectedGames.add(checkHill.text.toString())
            if (checkJump.isChecked) selectedGames.add(checkJump.text.toString())
            if (checkSoccer.isChecked) selectedGames.add(checkSoccer.text.toString())
            if (checkRadiant.isChecked) selectedGames.add(checkRadiant.text.toString())

            if (selectedGames.isNotEmpty()) {
                val message = "Has elegido: ${selectedGames.joinToString(", ")}"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No has elegido ninguna opción", Toast.LENGTH_SHORT).show()
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