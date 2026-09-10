package br.unisanta.tp4unisantaparte2.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.tp4unisantaparte2.R
import br.unisanta.tp4unisantaparte2.dao.TarefaDao
import br.unisanta.tp4unisantaparte2.model.Tarefa

class TarefaAdapter(private val tarefas: List<Tarefa>) :
    RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome_tarefa)
        val txvDescricao: TextView = itemView.findViewById(R.id.txv_descricao_tarefa)
        val btnConcluir: Button = itemView.findViewById(R.id.btn_concluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tarefas.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.txvNome.text = tarefa.nome
        holder.txvDescricao.text = tarefa.descricao

        if (tarefa.concluida) {
            holder.btnConcluir.text = "Concluída"
            holder.btnConcluir.isEnabled = false
            holder.txvNome.paintFlags = holder.txvNome.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.btnConcluir.text = "Concluir"
            holder.btnConcluir.isEnabled = true
            holder.txvNome.paintFlags = holder.txvNome.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        holder.btnConcluir.setOnClickListener {
            TarefaDao.concluir(position)
            notifyItemChanged(position)
        }
    }
}