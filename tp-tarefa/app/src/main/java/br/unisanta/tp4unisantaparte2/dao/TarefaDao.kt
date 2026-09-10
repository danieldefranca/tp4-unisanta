package br.unisanta.tp4unisantaparte2.dao

import br.unisanta.tp4unisantaparte2.model.Tarefa

class TarefaDao {
    companion object {
        private val tarefas = mutableListOf<Tarefa>()

        fun salvar(nome: String, descricao: String): String {
            tarefas.add(Tarefa(nome, descricao))
            return "Tarefa adicionada"
        }

        fun buscar(): List<Tarefa> {
            return tarefas
        }

        fun concluir(position: Int) {
            tarefas[position].concluida = true
        }
    }
}