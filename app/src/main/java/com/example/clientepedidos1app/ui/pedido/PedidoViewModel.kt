package com.example.clientepedidos1app.ui.pedido

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clientepedidos1app.data.model.Pedido
import com.example.clientepedidos1app.data.repository.PedidoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PedidoViewModel(private val repository: PedidoRepository) : ViewModel() {

    fun getPedidosByCliente(clienteId: Int): Flow<List<Pedido>> {
        return repository.getPedidosByCliente(clienteId)
    }

    fun getById(id: Int): Flow<Pedido> {
        return repository.getById(id)
    }

    fun insert(pedido: Pedido) = viewModelScope.launch {
        repository.insert(pedido)
    }

    fun update(pedido: Pedido) = viewModelScope.launch {
        repository.update(pedido)
    }

    fun delete(pedido: Pedido) = viewModelScope.launch {
        repository.delete(pedido)
    }
}
