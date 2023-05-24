package com.example.gcti.consult

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.R
import com.example.gcti.db.AppDatabase
import com.example.gcti.db.Chamado
import com.example.gcti.db.ChamadoDao
import kotlinx.coroutines.runBlocking

class ConsultTicketActivity : AppCompatActivity() {
    private lateinit var editTextProtocolo: EditText
    private lateinit var buttonConsultar: Button
    private lateinit var textViewResultado: TextView
    private lateinit var chamadoDao: ChamadoDao
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consult_ticket)

        editTextProtocolo = findViewById(R.id.editTextProtocolo)
        buttonConsultar = findViewById(R.id.buttonConsultar)
        textViewResultado = findViewById(R.id.textViewResultado)

        // Inicialize o banco de dados
        db = AppDatabase.getInstance(this)

        // Inicialize o chamadoDao com o DAO do banco de dados
        chamadoDao = db.chamadoDao()

        buttonConsultar.setOnClickListener {
            val protocolo = editTextProtocolo.text.toString()
            // Chame o método de consulta do chamado passando o número do protocolo
            consultarChamado(protocolo)
        }
    }

    private fun consultarChamado(protocolo: String) {
        // Consulte o chamado no banco de dados
        runBlocking {
            val chamado = chamadoDao.getChamadoByProtocolo(protocolo)
            exibirResultado(chamado)
        }
    }

    private fun exibirResultado(chamado: Chamado?) {
        if (chamado != null) {
            val resultado = "Número de protocolo: ${chamado.protocolo}\n" +
                    "Nome: ${chamado.nome}\n" +
                    "Setor: ${chamado.setor}\n" +
                    "Telefone: ${chamado.telefone}\n" +
                    "Descrição: ${chamado.descricao}\n" //+
                  //  "Status: ${chamado.status}"

            val intent = ResultadoConsultActivity.newIntent(this, resultado)
            startActivity(intent)
        } else {
            textViewResultado.text = "Chamado não localizado"
        }
    }

}
