package com.example.clientepedidos1app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clientepedidos1app.data.model.Pedido
import kotlinx.coroutines.flow.Flow

@Dao
interface PedidoDao {
    @Insert
    suspend fun insert(pedido: Pedido)

    @Update
    suspend fun update(pedido: Pedido)

    @Delete
    suspend fun delete(pedido: Pedido)

    @Query("SELECT * FROM pedidos WHERE clienteId = :clienteId ORDER BY producto ASC")
    fun getByClienteId(clienteId: Int): Flow<List<Pedido>>

    @Query("SELECT * FROM pedidos WHERE id = :id")
    fun getById(id: Int): Flow<Pedido>
}
