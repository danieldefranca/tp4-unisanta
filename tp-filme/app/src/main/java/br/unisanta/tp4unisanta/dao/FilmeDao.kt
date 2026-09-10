package br.unisanta.tp4unisanta.dao

import br.unisanta.tp4unisanta.model.Filme

class FilmeDao {
    companion object {
        private val filmes = mutableListOf<Filme>()

        fun salvar(titulo: String, diretor: String): String {
            filmes.add(Filme(titulo, diretor))
            return "Filme adicionado"
        }

        fun buscar(): List<Filme> {
            return filmes
        }
    }
}