package com.example.neighbours_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.neighbours_app.data.GlobleBottomNavigation
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications

val items = listOf(
    GlobleBottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home,
        route = "home"
    ),

    GlobleBottomNavigation(
        title = "Neighbours",
        icon = Icons.Rounded.Face,
        route = "neighbours"

    ),

    GlobleBottomNavigation(
        title = "Notifications",
        icon = Icons.Rounded.Notifications,
        route = "notifications"

    ),

    GlobleBottomNavigation(
        title = "Account",
        icon = Icons.Rounded.AccountCircle,
        route = "account"

    )
)


@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = navController.currentDestination?.route == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}
