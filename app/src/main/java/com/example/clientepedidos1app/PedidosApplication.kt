package com.example.clientepedidos1app

import android.app.Application
import com.example.clientepedidos1app.di.AppContainer
import com.example.clientepedidos1app.di.DefaultAppContainer

class PedidosApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}
