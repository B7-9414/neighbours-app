package com.example.neighbours_app
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home Screen")
            Spacer(modifier = Modifier.height(16.dp))
            PersonalUserLink(navController, name = "Moti")
            PersonalUserLink(navController, name = "Rohit")
            PersonalUserLink(navController, name = "James")
            PersonalUserLink(navController, name = "Bassam")
            PersonalUserLink(navController, name = "Farshad")

        }
    }
}

@Composable
fun PersonalUserLink(navController: NavController, name: String) {
    // we could pass the userID as well !!
    Button(onClick = { navController.navigate("personal_screen/$name") }) {
        Text(text = "Visit Personal Screen $name")
    }
}