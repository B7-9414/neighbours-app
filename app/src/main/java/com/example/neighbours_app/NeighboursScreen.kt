package com.example.neighbours_app
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NeighboursScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Neighbours",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                PersonalUserLink(navController, name = "Moti")
                PersonalUserLink(navController, name = "Rohit")
                PersonalUserLink(navController, name = "James")
                PersonalUserLink(navController, name = "Bassam")
                PersonalUserLink(navController, name = "Farshad")
            }
        }
    }
}

@Composable
fun PersonalUserLink(navController: NavController, name: String) {
    Text(
        text = "Visit $name's Personal Screen",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.clickable {
            navController.navigate("personal_screen/$name")
        }
    )
}
