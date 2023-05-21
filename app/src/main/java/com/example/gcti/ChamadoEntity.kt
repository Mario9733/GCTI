package com.example.gcti
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Database
import androidx.room.RoomDatabase

@Entity(tableName = "chamados")
data class ChamadoEntity(
    @PrimaryKey val protocolo: String,
    val nome: String,
    val setor: String,
    val telefone: String,
    val descricao: String,
    val imagemPath: String
)

@Database(entities = [ChamadoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chamadoDao(): ChamadoDao
}
