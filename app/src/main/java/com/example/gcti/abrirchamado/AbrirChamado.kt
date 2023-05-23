package com.example.gcti.abrirchamado
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.R

class AbrirChamado : AppCompatActivity() {
    private lateinit var editTextNome: EditText
    private lateinit var editTextSetor: EditText
    private lateinit var editTextTelefone: EditText
    private lateinit var buttonContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abrirchamado1)

        editTextNome = findViewById(R.id.chamadonome)
        editTextSetor = findViewById(R.id.chamadolocal)
        editTextTelefone = findViewById(R.id.chamadocllr)
        buttonContinuar = findViewById(R.id.btncontinuechamado1)

        buttonContinuar.setOnClickListener {
            val nome = editTextNome.text.toString()
            val setor = editTextSetor.text.toString()
            val telefone = editTextTelefone.text.toString()

            // Navegar para a próxima tela (CreateTicket2) passando os dados inseridos
            val intent = Intent(this, AbrirChamado2::class.java)
            intent.putExtra("nome", nome)
            intent.putExtra("setor", setor)
            intent.putExtra("telefone", telefone)
            startActivity(intent)
        }
    }
}