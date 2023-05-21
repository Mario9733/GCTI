package com.example.gcti.create

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.R

class CreateTicketActivity : AppCompatActivity() {
    private lateinit var editTextNome: EditText
    private lateinit var editTextSetor: EditText
    private lateinit var editTextTelefone: EditText
    private lateinit var buttonContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_ticket)

        editTextNome = findViewById(R.id.chamadonome)
        editTextSetor = findViewById(R.id.chamadolocal)
        editTextTelefone = findViewById(R.id.chamadocllr)
        buttonContinuar = findViewById(R.id.btncontinuechamado1)

        buttonContinuar.setOnClickListener {
            val nome = editTextNome.text.toString()
            val setor = editTextSetor.text.toString()
            val telefone = editTextTelefone.text.toString()

            // Navegar para a próxima tela (AbrirChamado2Activity) passando os dados inseridos
            val intent = Intent(this, CreateTicket2::class.java)
            intent.putExtra("nome", nome)
            intent.putExtra("setor", setor)
            intent.putExtra("telefone", telefone)
            startActivity(intent)
        }
    }
}
