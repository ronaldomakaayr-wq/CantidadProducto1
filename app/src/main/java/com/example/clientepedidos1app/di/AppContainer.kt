package com.example.clientepedidos1app.di

import android.content.Context
import com.example.clientepedidos1app.data.AppDatabase
import com.example.clientepedidos1app.data.repository.ClienteRepository
import com.example.clientepedidos1app.data.repository.PedidoRepository

interface AppContainer {
    val clienteRepository: ClienteRepository
    val pedidoRepository: PedidoRepository
}

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val database by lazy {
        AppDatabase.getDatabase(context)
    }

    override val clienteRepository: ClienteRepository by lazy {
        ClienteRepository(database.clienteDao())
    }

    override val pedidoRepository: PedidoRepository by lazy {
        PedidoRepository(database.pedidoDao())
    }
}
