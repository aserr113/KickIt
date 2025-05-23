package com.example.kickit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.*
import kotlinx.coroutines.delay
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "loading") {
                composable("loading") { LoadingScreen(navController) }
                composable("login") { LoginScreen() }
            }
        }
    }
}

@Composable
fun LoadingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Loading...",
            fontSize = 24.sp,
            color = Color.White
        )
    }
    LaunchedEffect(Unit) {
        delay(2000) // Show loading screen for 2 seconds
        navController.navigate("login")
    }
}

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            TextField(value = username, onValueChange = { username = it }, placeholder = { Text("Username") })
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = password, onValueChange = { password = it }, placeholder = { Text("Password") })
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Handle login */ }) {
                Text(text = "Login")
            }
        }
    }
}