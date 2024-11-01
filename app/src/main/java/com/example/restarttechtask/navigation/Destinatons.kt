package com.example.restarttechtask.navigation

sealed class Screen(val route: String, val title: String, val label: String) {
    object Home : Screen("home", "Home", "Accueil")
    object Connect : Screen("connect", "Connect", "Connect")
    object Questions : Screen("questions", "Questions", "Questions")
    object Profile : Screen("profile", "Profile", "Profile")
    object Tools : Screen("tools", "Tools", "Tools")
}