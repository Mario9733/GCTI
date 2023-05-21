package com.example.gcti

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TicketDetailsActivity : AppCompatActivity() {
    private lateinit var tvchamadonome: TextView
    private lateinit var tvchamadolocal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_details)

        tvchamadonome = findViewById(R.id.tvTicketTitle)
        tvchamadolocal = findViewById(R.id.tvTicketDescription)

        val ticket = intent.getStringExtra("Nome")
        tvchamadonome.text = ticket
        // Obtenha a descrição completa do chamado do banco de dados ou de outra fonte de dados
        tvchamadolocal.text = "Local do Chamado: $ticket"
    }
}
