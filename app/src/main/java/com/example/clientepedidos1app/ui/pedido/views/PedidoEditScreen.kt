package com.example.clientepedidos1app.ui.pedido.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.clientepedidos1app.data.model.Pedido
import com.example.clientepedidos1app.ui.pedido.PedidoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidoEditScreen(
    navController: NavController,
    viewModel: PedidoViewModel,
    clienteId: Int,
    pedidoId: Int? = null
) {
    var producto by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }

    if (pedidoId != null) {
        val pedido by viewModel.getById(pedidoId).collectAsState(initial = null)
        LaunchedEffect(pedido) {
            pedido?.let {
                producto = it.producto
                cantidad = it.cantidad.toString()
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (pedidoId == null) "Añadir Pedido" else "Editar Pedido") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = producto,
                onValueChange = { producto = it },
                label = { Text("Producto") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = cantidad,
                onValueChange = { cantidad = it },
                label = { Text("Cantidad") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    val pedido = Pedido(
                        id = pedidoId ?: 0,
                        clienteId = clienteId,
                        producto = producto,
                        cantidad = cantidad.toIntOrNull() ?: 0
                    )
                    if (pedidoId == null) {
                        viewModel.insert(pedido)
                    } else {
                        viewModel.update(pedido)
                    }
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
