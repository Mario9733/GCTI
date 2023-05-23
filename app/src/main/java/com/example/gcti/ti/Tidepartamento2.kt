package com.example.gcti.ti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gcti.R

class ITDepartmentActivity : AppCompatActivity() {


    private val validUsername = "admin"
    private val validPassword = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_it_department)

//        btnLogin.setOnClickListener {
//            val username = etUsername.text.toString()
//            val password = etPassword.text.toString()
//
//            if (isValidCredentials(username, password)) {
//                 Credenciais válidas, navegue para a MainActivity
//                val intent = Intent(this, ITDepartment2::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                 Credenciais inválidas, exiba uma mensagem de erro
//                tvError.text = getString(R.string.invalid_credentials)
//            }
//        }
    }
//    private fun isValidCredentials(username: String, password: String): Boolean {
//        return username == validUsername && password == validPassword
//    }


}