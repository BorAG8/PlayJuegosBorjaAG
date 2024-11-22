package com.example.playjuegosborjaag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class GenerosAdapter(private val generos: List<String>, private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<GenerosAdapter.GeneroViewHolder>() {

    inner class GeneroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val buttonGenero: Button = view.findViewById(R.id.buttonGenero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genero, parent, false)
        return GeneroViewHolder(view)
    }

    override fun onBindViewHolder(holder: GeneroViewHolder, position: Int) {
        val genero = generos[position]
        holder.buttonGenero.text = genero
        holder.buttonGenero.setOnClickListener { onClick(genero) }
    }

    override fun getItemCount(): Int = generos.size
}