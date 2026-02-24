package com.example.clientepedidos1app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.clientepedidos1app.ui.AppNavigator
import com.example.clientepedidos1app.ui.theme.ModernAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModernAppTheme {
                AppNavigator()
            }
        }
    }
}
