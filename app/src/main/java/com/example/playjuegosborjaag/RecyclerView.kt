package com.example.playjuegosborjaag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

/**
 * GenerosAdapter - Maneja la visualización e interacción con una lista de géneros.
 * @param generos Lista de géneros a mostrar.
 * @param onClick Callback para manejar eventos de clic en los géneros.
 */
class GenerosAdapter(
    private val generos: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<GenerosAdapter.GeneroViewHolder>() {

    /**
     * GeneroViewHolder - ViewHolder para un género, contiene un botón que representa cada género.
     */
    inner class GeneroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val buttonGenero: Button = view.findViewById(R.id.buttonGenero)
    }

    /**
     * Crea una nueva vista para representar un género.
     * @param parent Vista padre que contiene los elementos del RecyclerView.
     * @param viewType Tipo de vista.
     * @return Un nuevo ViewHolder para un género.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genero, parent, false)
        return GeneroViewHolder(view)
    }

    /**
     * Vincula los datos de un género al ViewHolder.
     * @param holder ViewHolder que debe actualizarse.
     * @param position Posición del elemento en la lista.
     */
    override fun onBindViewHolder(holder: GeneroViewHolder, position: Int) {
        val genero = generos[position]
        holder.buttonGenero.text = genero
        holder.buttonGenero.setOnClickListener { onClick(genero) }
    }

    /**
     * Obtiene el número total de elementos en la lista.
     * @return Número de géneros en la lista.
     */
    override fun getItemCount(): Int = generos.size
}