package com.example.restarttechtask.screens

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.restarttechtask.navigation.BottomNavigationBar
import com.example.restarttechtask.navigation.NavigationHost
import com.example.restarttechtask.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    OverlayScreen() {
        Scaffold(
            topBar = {
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route
                val currentScreen = getScreenFromRoute(currentRoute)

                TopAppBar(
                    title = { Text(text = currentScreen?.title ?: "App") },

                    )
            },
            contentWindowInsets = WindowInsets.safeContent,
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) { innerPadding ->
            NavigationHost(navController, Modifier.padding(innerPadding))
        }
    }
}

fun getScreenFromRoute(route: String?): Screen? {
    return when (route) {
        Screen.Home.route -> Screen.Home
        Screen.Connect.route -> Screen.Connect
        Screen.Questions.route -> Screen.Questions
        else -> null
    }
}
