package com.example.playjuegosborjaag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonaAdapter(
    private val personas: List<Persona>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {

    inner class PersonaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvHoras: TextView = view.findViewById(R.id.horasJuego)
        val ivFoto: ImageView = view.findViewById(R.id.imageView)

        fun bind(persona: Persona) {
            tvNombre.text = persona.nombre
            tvHoras.text = persona.horas
            ivFoto.setImageResource(persona.foto)

            itemView.setOnClickListener {
                onClick(persona.nombre)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return PersonaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.bind(personas[position])
    }

    override fun getItemCount(): Int = personas.size
}