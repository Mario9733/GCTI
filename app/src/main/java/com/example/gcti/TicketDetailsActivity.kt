package com.example.gcti

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class TicketDetailsActivity : AppCompatActivity() {
    private lateinit var tvTicketTitle: TextView
    private lateinit var tvTicketDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_details)

        tvTicketTitle = findViewById(R.id.tvTicketTitle)
        tvTicketDescription = findViewById(R.id.tvTicketDescription)

        val ticket = intent.getStringExtra("ticket")
        tvTicketTitle.text = ticket
        // Obtenha a descrição completa do chamado do banco de dados ou de outra fonte de dados
        tvTicketDescription.text = "Descrição do chamado: $ticket"
    }
}
