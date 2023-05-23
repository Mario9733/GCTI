package com.example.gcti.db
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chamados")
data class Chamado(
    @PrimaryKey val protocolo: String,
    val nome: String,
    val setor: String,
    val telefone: String,
    val descricao: String,
    val imagemPath: String
)

