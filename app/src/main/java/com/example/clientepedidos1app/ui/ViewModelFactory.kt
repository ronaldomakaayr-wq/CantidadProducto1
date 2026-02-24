package com.example.clientepedidos1app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.clientepedidos1app.PedidosApplication
import com.example.clientepedidos1app.ui.cliente.ClienteViewModel
import com.example.clientepedidos1app.ui.pedido.PedidoViewModel

object AppViewModelProvider {
    val Factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            return when {
                modelClass.isAssignableFrom(ClienteViewModel::class.java) -> {
                    ClienteViewModel(extras.pedidosApplication().container.clienteRepository) as T
                }
                modelClass.isAssignableFrom(PedidoViewModel::class.java) -> {
                    PedidoViewModel(extras.pedidosApplication().container.pedidoRepository) as T
                }
                else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
            }
        }
    }
}

fun CreationExtras.pedidosApplication(): PedidosApplication =
    this[APPLICATION_KEY] as PedidosApplication
