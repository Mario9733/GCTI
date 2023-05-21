package com.example.gcti.create

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.R.*

class CreateTicket2 : AppCompatActivity() {
    private lateinit var editTextDescricao: EditText
    private lateinit var buttonContinuar2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_create2)

        editTextDescricao = findViewById(id.descricao)
        buttonContinuar2 = findViewById(id.btncontinuechamado2)

        buttonContinuar2.setOnClickListener {
            val descricao = editTextDescricao.text.toString()

            // Navegar para a próxima tela (AbrirChamado3Activity) passando a descrição do defeito
            val intent = Intent(this, CreateTicket3::class.java)
            intent.putExtra("descricao", descricao)
            startActivity(intent)
        }
    }
}
