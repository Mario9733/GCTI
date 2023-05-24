package com.example.gcti.abrirchamado

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.MainActivity
import com.example.gcti.R

class ProtocoloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protocolo)

        val protocolo = intent.getStringExtra("protocolo")

        val textViewProtocolo = findViewById<TextView>(R.id.textViewProtocolo)
        textViewProtocolo.text = "Número de protocolo: $protocolo"

        val buttonVoltar = findViewById<Button>(R.id.buttonVoltar)
        buttonVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}

