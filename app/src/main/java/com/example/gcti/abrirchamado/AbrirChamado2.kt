package com.example.gcti.abrirchamado

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.R.id
import com.example.gcti.R.layout

class AbrirChamado2 : AppCompatActivity() {
    private lateinit var editTextDescricao: EditText
    private lateinit var buttonContinuar2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_abrirchamado2)

       editTextDescricao = findViewById(id.et_problem_description)
        buttonContinuar2 = findViewById(id.btncontinuechamado2)

        buttonContinuar2.setOnClickListener {
            val descricao = editTextDescricao.text.toString()

            // Navegar para a próxima tela (AbrirChamado3Activity) passando a descrição do defeito
            val intent = Intent(this, AbrirChamado3::class.java)
            intent.putExtra("descricao", descricao)
            startActivity(intent)
        }
    }
}
