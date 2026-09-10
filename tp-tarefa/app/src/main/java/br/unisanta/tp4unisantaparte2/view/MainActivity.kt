package br.unisanta.tp4unisantaparte2.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.tp4unisantaparte2.R
import br.unisanta.tp4unisantaparte2.adapter.TarefaAdapter
import br.unisanta.tp4unisantaparte2.dao.TarefaDao

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var rvTarefas: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtNome = findViewById<EditText>(R.id.edt_nome_tarefa)
        val edtDescricao = findViewById<EditText>(R.id.edt_descricao_tarefa)
        val btnAdicionar = findViewById<Button>(R.id.btn_adicionar_tarefa)
        rvTarefas = findViewById(R.id.rv_tarefas)

        rvTarefas.layoutManager = LinearLayoutManager(this)
        rvTarefas.adapter = TarefaAdapter(TarefaDao.buscar())

        btnAdicionar.setOnClickListener {
            val nome = edtNome.text.toString()
            val descricao = edtDescricao.text.toString()

            if (nome.isNotBlank()) {
                TarefaDao.salvar(nome, descricao)
                rvTarefas.adapter?.notifyItemInserted(TarefaDao.buscar().size - 1)
                edtNome.text.clear()
                edtDescricao.text.clear()
            } else {
                Toast.makeText(this, "Digite o nome da tarefa", Toast.LENGTH_SHORT).show()
            }
        }
    }
}