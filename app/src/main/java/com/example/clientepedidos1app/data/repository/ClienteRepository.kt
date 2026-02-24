package com.example.clientepedidos1app.data.repository

import com.example.clientepedidos1app.data.dao.ClienteDao
import com.example.clientepedidos1app.data.model.Cliente
import kotlinx.coroutines.flow.Flow

class ClienteRepository(private val clienteDao: ClienteDao) {

    val allClientes: Flow<List<Cliente>> = clienteDao.getAll()

    suspend fun insert(cliente: Cliente) {
        clienteDao.insert(cliente)
    }

    suspend fun update(cliente: Cliente) {
        clienteDao.update(cliente)
    }

    suspend fun delete(cliente: Cliente) {
        clienteDao.delete(cliente)
    }

    fun getById(id: Int): Flow<Cliente> {
        return clienteDao.getById(id)
    }
}
