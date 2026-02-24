package com.example.clientepedidos1app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clientepedidos1app.data.dao.ClienteDao
import com.example.clientepedidos1app.data.dao.PedidoDao
import com.example.clientepedidos1app.data.model.Cliente
import com.example.clientepedidos1app.data.model.Pedido

@Database(entities = [Cliente::class, Pedido::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun pedidoDao(): PedidoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                .build()
                .also { INSTANCE = it }
            }
        }
    }
}
