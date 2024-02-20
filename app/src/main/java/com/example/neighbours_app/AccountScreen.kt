package com.example.neighbours_app
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccountScreen(onLoginSuccess: () -> Unit, navController: NavController) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loggedIn by remember { mutableStateOf(false) } // Track login state

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            TextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { /* Handle next action */ })
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    // Perform login authentication here
                    if (AuthUtils.authenticate(userName, password)) {
                        // If login successful, update login state and navigate
                        loggedIn = true
                        onLoginSuccess()
                    }
                })
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Perform login authentication here
                if (AuthUtils.authenticate(userName, password)) {
                    // If login successful, update login state and navigate
                    loggedIn = true
                    onLoginSuccess()
                }
            }) {
                Text("Log In")
            }

            // Show welcome message if logged in
            if (loggedIn) {
                Text("Welcome, $userName!")
            }
        }
    }
}
