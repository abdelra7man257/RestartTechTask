package com.example.restarttechtask.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.restarttechtask.screens.ConnectionsScreen
import com.example.restarttechtask.screens.HomeScreen
import com.example.restarttechtask.screens.MainQuestionsScreen

@Composable
fun NavigationHost(navController: NavController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(modifier) }
        composable(Screen.Connect.route) { ConnectionsScreen(modifier) }
        composable(Screen.Questions.route) { MainQuestionsScreen(modifier) }
    }

}