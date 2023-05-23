package com.example.gcti.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChamadoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChamado(chamado: Chamado)

    @Query("SELECT * FROM chamados WHERE protocolo = :protocolo")
    suspend fun getChamadoByProtocolo(protocolo: String): Chamado?
}
