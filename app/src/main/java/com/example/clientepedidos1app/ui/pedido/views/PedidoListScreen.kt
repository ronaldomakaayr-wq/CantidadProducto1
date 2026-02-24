package com.example.clientepedidos1app.ui.pedido.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.clientepedidos1app.ui.pedido.PedidoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidoListScreen(navController: NavController, viewModel: PedidoViewModel, clienteId: Int) {
    val pedidos by viewModel.getPedidosByCliente(clienteId).collectAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Pedidos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("pedido_add/$clienteId") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Order")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(pedidos) { pedido ->
                ListItem(
                    headlineContent = { Text(pedido.producto) },
                    supportingContent = { Text("Cantidad: ${pedido.cantidad}") },
                    modifier = Modifier.clickable { navController.navigate("pedido_edit/$clienteId/${pedido.id}") }
                )
            }
        }
    }
}
