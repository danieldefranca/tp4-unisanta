package br.unisanta.tp4unisanta.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.unisanta.tp4unisanta.R
import br.unisanta.tp4unisanta.adapter.FilmeAdapter
import br.unisanta.tp4unisanta.dao.FilmeDao
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var rvFilmes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
        val edtDiretor = findViewById<EditText>(R.id.edt_diretor)
        val btnAdicionar = findViewById<Button>(R.id.btn_adicionar)
        rvFilmes = findViewById(R.id.rv_filmes)

        rvFilmes.layoutManager = GridLayoutManager(this, 2)
        rvFilmes.adapter = FilmeAdapter(FilmeDao.buscar())

        btnAdicionar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val diretor = edtDiretor.text.toString()

            if (titulo.isNotBlank() && diretor.isNotBlank()) {
                FilmeDao.salvar(titulo, diretor)
                rvFilmes.adapter?.notifyItemInserted(FilmeDao.buscar().size - 1)
                edtTitulo.text.clear()
                edtDiretor.text.clear()
            } else {
                Toast.makeText(this, "Preencha título e diretor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}