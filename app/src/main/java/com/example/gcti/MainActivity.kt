package com.example.gcti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.abrirchamado.AbrirChamado
import com.example.gcti.consult.ConsultTicketActivity
import com.example.gcti.ti.ITDepartmento

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        listViewTickets = findViewById(R.id.btnConsultTicket)
//        val btncontinueTicket: Button = findViewById(R.id.btnCreateTicket)
//        btncontinueTicket.setOnClickListener()
//        {
//            val intent = Intent(this, CreateTicketActivity::class.java)
//            startActivity(intent)
//        }
        // Exemplo de lista de chamados (substitua por seus próprios dados)
//        val chamadoList = listOf("Chamado 1", "Chamado 2", "Chamado 3")

//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chamadoList)
//        listViewTickets.adapter = adapter

//        listViewTickets.setOnItemClickListener {
//            val ticket = chamadoList[position]
//            val intent = Intent(this, TicketDetailsActivity::class.java)
//            intent.putExtra("ticket", ticket)
//            startActivity(intent)

        }

    fun openCreateTicketActivity(view: android.view.View) {
        val intent = Intent(this, AbrirChamado::class.java)
        startActivity(intent)
    }

    fun openConsultTicketActivity(view: android.view.View) {
        val intent = Intent(this, ConsultTicketActivity::class.java)
        startActivity(intent)
    }

    fun openITDepartmentActivity(view: android.view.View) {
        val intent = Intent(this, ITDepartmento::class.java)
        startActivity(intent)
    }

}
