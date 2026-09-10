package br.unisanta.tp4unisanta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.tp4unisanta.R
import br.unisanta.tp4unisanta.model.Filme

class FilmeAdapter(private val filmes: List<Filme>) :
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvTitulo: TextView = itemView.findViewById(R.id.txv_titulo_filme)
        val txvDiretor: TextView = itemView.findViewById(R.id.txv_diretor_filme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txvTitulo.text = filmes[position].titulo
        holder.txvDiretor.text = filmes[position].diretor
    }
}