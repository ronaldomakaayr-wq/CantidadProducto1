package com.example.clientepedidos1app.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clientepedidos1app.ui.cliente.ClienteViewModel
import com.example.clientepedidos1app.ui.cliente.views.ClienteEditScreen
import com.example.clientepedidos1app.ui.cliente.views.ClienteListScreen
import com.example.clientepedidos1app.ui.pedido.PedidoViewModel
import com.example.clientepedidos1app.ui.pedido.views.PedidoEditScreen
import com.example.clientepedidos1app.ui.pedido.views.PedidoListScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    val clienteViewModel: ClienteViewModel = viewModel(factory = AppViewModelProvider.Factory)
    val pedidoViewModel: PedidoViewModel = viewModel(factory = AppViewModelProvider.Factory)

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("cliente_list") {
            ClienteListScreen(navController = navController, viewModel = clienteViewModel)
        }
        composable(
            route = "cliente_edit/{clienteId}",
            arguments = listOf(navArgument("clienteId") { type = NavType.IntType })
        ) {
            val clienteId = it.arguments?.getInt("clienteId")
            ClienteEditScreen(navController = navController, viewModel = clienteViewModel, clienteId = clienteId)
        }
        composable("cliente_add") {
            ClienteEditScreen(navController = navController, viewModel = clienteViewModel)
        }
        composable(
            route = "pedido_list/{clienteId}",
            arguments = listOf(navArgument("clienteId") { type = NavType.IntType })
        ) {
            val clienteId = it.arguments?.getInt("clienteId") ?: 0
            PedidoListScreen(navController = navController, viewModel = pedidoViewModel, clienteId = clienteId)
        }
        composable(
            route = "pedido_add/{clienteId}",
            arguments = listOf(navArgument("clienteId") { type = NavType.IntType })
        ) {
            val clienteId = it.arguments?.getInt("clienteId") ?: 0
            PedidoEditScreen(navController = navController, viewModel = pedidoViewModel, clienteId = clienteId)
        }
        composable(
            route = "pedido_edit/{clienteId}/{pedidoId}",
            arguments = listOf(
                navArgument("clienteId") { type = NavType.IntType },
                navArgument("pedidoId") { type = NavType.IntType }
            )
        ) {
            val clienteId = it.arguments?.getInt("clienteId") ?: 0
            val pedidoId = it.arguments?.getInt("pedidoId")
            PedidoEditScreen(
                navController = navController,
                viewModel = pedidoViewModel,
                clienteId = clienteId,
                pedidoId = pedidoId
            )
        }
    }
}
