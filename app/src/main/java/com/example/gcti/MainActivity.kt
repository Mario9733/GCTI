package com.example.gcti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openCreateTicketActivity(view: android.view.View) {
        val intent = Intent(this, CreateTicketActivity::class.java)
        startActivity(intent)
    }

    fun openConsultTicketActivity(view: android.view.View) {
        val intent = Intent(this, ConsultTicketActivity::class.java)
        startActivity(intent)
    }

    fun openITDepartmentActivity(view: android.view.View) {
        val intent = Intent(this, ITDepartmentActivity::class.java)
        startActivity(intent)
    }
}
