package com.example.gcti.consult

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.R

class ConsultTicketActivity : AppCompatActivity() {
    private lateinit var editTextProtocolo: EditText
    private lateinit var buttonConsultar: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consult_ticket)

        editTextProtocolo = findViewById(R.id.editTextProtocolo)
        buttonConsultar = findViewById(R.id.buttonConsultar)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonConsultar.setOnClickListener {
            val protocolo = editTextProtocolo.text.toString()
            // Chame o método de consulta do chamado passando o número do protocolo
            consultarChamado(protocolo)
        }
    }

    private fun consultarChamado(protocolo: String) {
        // Implemente a lógica de consulta do chamado no banco de dados
        // Aqui você pode usar a classe que representa o banco de dados e realizar a consulta pelo número de protocolo

        // Exemplo de resultado
        val resultado = "Chamado não localizado"
        // Se o chamado for encontrado, atribua as informações correspondentes à variável resultado

        textViewResultado.text = resultado
    }
}

