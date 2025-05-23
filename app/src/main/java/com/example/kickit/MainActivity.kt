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
            NavHost(navController = navController, startDestination = "loading_screen") {
                composable("loading_screen") { LoadingScreen(navController) }
                composable("login_screen") { LoginScreen(navController) }
                composable("signup") { SignUpScreen() }
                composable("login_form") { LoginFormScreen() }
                composable("guest_home") { GuestHomeScreen() }
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
            text = "Kick It...",
            fontSize = 24.sp,
            color = Color.White
        )
    }
    LaunchedEffect(Unit) {
        delay(2000) // Show loading screen for 3 seconds
        navController.navigate("login_screen")
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        // App Name (Centered Text)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Kick It",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        // Bottom-Aligned Buttons (Side by Side)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly // Places buttons next to each other
        ) {
            Button(onClick = { navController.navigate("signup") }) {
                Text(text = "Sign Up")
            }
            Button(onClick = { navController.navigate("login_form") }) {
                Text(text = "Login")
            }
        }

        // Discreet Guest Button (Top Right Corner)
        // Move "Continue as Guest" button to the left side
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 16.dp) // Shift to left instead of right
                .align(Alignment.TopStart) // Align to top left
        ) {
            TextButton(onClick = { navController.navigate("guest_home") }) {
                Text(text = "Continue as Guest", color = Color.Gray) // Subtle styling
            }
        }

    }
}

@Composable
fun SignUpScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Sign Up Screen", fontSize = 24.sp)
    }
}

@Composable
fun LoginFormScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Login Form Screen", fontSize = 24.sp)
    }
}

@Composable
fun GuestHomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Welcome, Guest!", fontSize = 24.sp, color = Color.White)
    }
}