package com.example.clientepedidos1app.ui.cliente

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clientepedidos1app.data.model.Cliente
import com.example.clientepedidos1app.data.repository.ClienteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ClienteViewModel(private val repository: ClienteRepository) : ViewModel() {

    val clientes: StateFlow<List<Cliente>> = repository.allClientes
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun getById(id: Int): Flow<Cliente> {
        return repository.getById(id)
    }

    fun insert(cliente: Cliente) = viewModelScope.launch {
        repository.insert(cliente)
    }

    fun update(cliente: Cliente) = viewModelScope.launch {
        repository.update(cliente)
    }

    fun delete(cliente: Cliente) = viewModelScope.launch {
        repository.delete(cliente)
    }
}
