package com.example.clientepedidos1app.data.repository

import com.example.clientepedidos1app.data.dao.PedidoDao
import com.example.clientepedidos1app.data.model.Pedido
import kotlinx.coroutines.flow.Flow

class PedidoRepository(private val pedidoDao: PedidoDao) {

    fun getPedidosByCliente(clienteId: Int): Flow<List<Pedido>> {
        return pedidoDao.getByClienteId(clienteId)
    }

    fun getById(id: Int): Flow<Pedido> {
        return pedidoDao.getById(id)
    }

    suspend fun insert(pedido: Pedido) {
        pedidoDao.insert(pedido)
    }

    suspend fun update(pedido: Pedido) {
        pedidoDao.update(pedido)
    }

    suspend fun delete(pedido: Pedido) {
        pedidoDao.delete(pedido)
    }
}
