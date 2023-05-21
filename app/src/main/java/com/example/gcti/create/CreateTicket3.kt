package com.example.gcti.create

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.gcti.AppDatabase
import com.example.gcti.ChamadoDao
import com.example.gcti.ChamadoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import com.example.gcti.R
import com.google.android.gms.cast.framework.media.ImagePicker
import com.github.dhaval2404.imagepicker.ImagePicker




class CreateTicket3 : AppCompatActivity() {
    private lateinit var buttonSelecionarImagem: Button
    private lateinit var imageViewImagem: ImageView
    private lateinit var buttonSalvar: Button
    private lateinit var chamadoDao: ChamadoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create3)

        buttonSelecionarImagem = findViewById(R.id.buttonSelecionarImagem)
        imageViewImagem = findViewById(R.id.imageViewImagem)
        buttonSalvar = findViewById(R.id.buttonSalvar)

        buttonSelecionarImagem.setOnClickListener {
            ImagePicker.with(this)
                .galleryOnly()
                .start { resultCode, data ->
                    if (resultCode == Activity.RESULT_OK) {
                        val fileUri = data?.data
                        imageViewImagem.setImageURI(fileUri)
                    }
                }
        }

        buttonSalvar.setOnClickListener {
            val database = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "chamados-database"
            ).build()
            chamadoDao = database.chamadoDao()



            val nome = "Nome do Chamado" // Obtenha o valor do campo de entrada do nome
            val setor = "Setor do Chamado" // Obtenha o valor do campo de entrada do setor
            val telefone = "Telefone do Chamado" // Obtenha o valor do campo de entrada do telefone
            val descricao = "Descrição do Chamado" // Obtenha o valor do campo de entrada da descrição
            val imagePath = "Caminho da Imagem" // Obtenha o caminho da imagem selecionada




            GlobalScope.launch(Dispatchers.IO) {
                val protocolo = generateProtocolo()
                val chamado = ChamadoEntity(
                    protocolo,
                    nome,
                    setor,
                    telefone,
                    descricao,
                    imagePath
                )
                chamadoDao.insertChamado(chamado)
            }

            val protocolo = generateProtocolo()
            Toast.makeText(
                this,
                "Chamado aberto. Número de protocolo: $protocolo",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }

    private fun generateProtocolo(): String {
        val currentDate = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())
        val sequencial = "01"
        return "$currentDate$sequencial"
    }
}
