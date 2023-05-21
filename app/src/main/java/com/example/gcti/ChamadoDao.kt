package com.example.gcti
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChamadoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChamado(chamado: ChamadoEntity)

    @Query("SELECT * FROM chamados WHERE protocolo = :protocolo")
    suspend fun getChamadoByProtocolo(protocolo: String): ChamadoEntity?
}
