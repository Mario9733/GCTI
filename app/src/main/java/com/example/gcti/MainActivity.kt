package com.example.gcti

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listViewTickets: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewTickets = findViewById(R.id.listViewTickets)
        val btnCreateTicket: Button = findViewById(R.id.btnCreateTicket)
        btnCreateTicket.setOnClickListener {
            val intent = Intent(this, CreateTicketActivity::class.java)
            startActivity(intent)
        }

        // Exemplo de lista de chamados (substitua por seus próprios dados)
        val ticketList = listOf("Chamado 1", "Chamado 2", "Chamado 3")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ticketList)
        listViewTickets.adapter = adapter

        listViewTickets.setOnItemClickListener { _, _, position, _ ->
            val ticket = ticketList[position]
            val intent = Intent(this, TicketDetailsActivity::class.java)
            intent.putExtra("ticket", ticket)
            startActivity(intent)
        }
    }
}
