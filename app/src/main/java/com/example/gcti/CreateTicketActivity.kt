package com.example.gcti

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateTicketActivity : AppCompatActivity() {
    private lateinit var etTicketTitle: EditText
    private lateinit var etTicketDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_ticket)

        etTicketTitle = findViewById(R.id.etTicketTitle)
        etTicketDescription = findViewById(R.id.etTicketDescription)
        val btnSaveTicket: Button = findViewById(R.id.btnSaveTicket)
        btnSaveTicket.setOnClickListener {
            val ticketTitle = etTicketTitle.text.toString()
            val ticketDescription = etTicketDescription.text.toString()
            // Salvar o chamado no banco de dados ou em outra estrutura de dados
            finish()
        }
    }
}
