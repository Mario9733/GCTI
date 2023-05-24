package com.example.gcti.ti

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.R

class ITDepartmento : AppCompatActivity() {
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_it_department)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username == "admin" && password == "1234") {
                // Login successful, navigate to TI activity
                val intent = Intent(this, ITDepartmento::class.java)
                startActivity(intent)
                finish()
            } else {
                // Invalid credentials, show error message
                Toast.makeText(this, "Usuário ou Senha Inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }

}