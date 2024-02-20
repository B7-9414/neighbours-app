package com.example.neighbours_app
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neighbours_app.ui.theme.NeighboursappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeighboursappTheme {
                NavGraph()
            }
        }
    }
}
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("neighbours"){
            NeighboursScreen(navController = navController)
        }
        composable("notifications"){
            NotificationsScreen(navController = navController)
        }
        composable("account"){
            AccountScreen(onLoginSuccess = { /* Implement login success logic here */ },
                navController = navController)
        }
        composable("personal_screen/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            // Pass empty strings for sharedString and updateString
            PersonalScreen(
                navController = navController,
                name = name,
            )
        }
    }
}
