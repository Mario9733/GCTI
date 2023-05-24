package com.example.gcti.abrirchamado

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.gcti.R
import com.example.gcti.db.AppDatabase
import com.example.gcti.db.Chamado
import com.example.gcti.db.ChamadoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AbrirChamado3 : AppCompatActivity() {
    private lateinit var btnSelectImagem: Button
    private lateinit var imageViewImagem: ImageView
    private lateinit var buttonSalvar: Button
    private lateinit var chamadoDao: ChamadoDao
    private lateinit var db: AppDatabase

    private val TAKE_PHOTO_REQUEST = 1
    private lateinit var imageUri: Uri
    private val takePhotoLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                enviarImagemAoSalvarEAbrirChamado(imageUri)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abrirchamado3)

        btnSelectImagem = findViewById(R.id.btnSelectImagem)

        btnSelectImagem.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED
            ) {
                takePhoto()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    TAKE_PHOTO_REQUEST
                )
            }
        }


        // Inicialize o banco de dados
        db = AppDatabase.getInstance(this)

        // Inicialize o chamadoDao com o DAO do banco de dados
        chamadoDao = db.chamadoDao()
    }

    private fun takePhoto() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "image.jpg")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image captured by camera")
        imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)!!
        takePhotoLauncher.launch(imageUri)
    }

    private fun enviarImagemAoSalvarEAbrirChamado(imageUri: Uri?) {
        // Verificar se a imagem foi capturada corretamente
        if (imageUri != null) {
            // Aqui você pode implementar a lógica para enviar a imagem ao servidor ou fazer o processamento necessário
            // Por exemplo, você pode usar uma biblioteca de upload de imagens como o Retrofit ou Volley para enviar a imagem para o servidor

            // Após o envio bem-sucedido, você pode salvar o chamado no banco de dados ou em qualquer outro local apropriado
            salvarChamadoNoBancoDeDados(imageUri)
        }
    }

    private fun salvarChamadoNoBancoDeDados(imageUri: Uri) {
        val nome = "Nome do Chamado" // Obtenha o valor do campo de entrada do nome
        val setor = "Setor do Chamado" // Obtenha o valor do campo de entrada do setor
        val telefone = "Telefone do Chamado" // Obtenha o valor do campo de entrada do telefone
        val descricao = "Descrição do Chamado" // Obtenha o valor do campo de entrada da descrição
        val imagePath = imageUri.toString() // Utilize o URI da imagem capturada

        val chamado = Chamado(
            generateProtocolo(),
            nome,
            setor,
            telefone,
            descricao,
            imagePath
        )

        lifecycleScope.launch(Dispatchers.IO) {
            chamadoDao.insertChamado(chamado)
        }

        val protocolo = chamado.protocolo
        Toast.makeText(
            this@AbrirChamado3,
            "Chamado aberto. Número de protocolo: $protocolo",
            Toast.LENGTH_LONG
        ).show()

        val intent = Intent(this@AbrirChamado3, ProtocoloActivity::class.java)
        intent.putExtra("protocolo", protocolo)
        startActivity(intent)

        finish()

    }

    private fun generateProtocolo(): String {
        val currentDate = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())
        val sequencial = "01"
        return "$currentDate$sequencial"
    }
}
