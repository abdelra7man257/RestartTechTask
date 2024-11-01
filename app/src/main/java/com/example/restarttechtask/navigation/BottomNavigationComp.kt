package com.example.restarttechtask.navigation

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.restarttechtask.R


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(Screen.Home, Screen.Connect, Screen.Questions, Screen.Tools, Screen.Profile)
    val itemsDestinations = listOf(0, 1, 2)
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.White
    ) {
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = currentBackStackEntry?.destination?.route

        items.forEachIndexed { Index, screen ->
            val selected = currentRoute == screen.route

            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            when (screen) {
                                Screen.Home -> R.drawable.home_simple_door
                                Screen.Connect -> R.drawable.chat_lines
                                Screen.Questions -> R.drawable.help_circle
                                Screen.Tools -> R.drawable.design_nib
                                Screen.Profile -> R.drawable.profile_circle
                            },
                        ),
                        contentDescription = screen.title,
                        tint = if (selected) Color(0xff33E2E1) else Color(0xff9CA3AF) // Custom icon color
                    )
                },

                label = {
                    Text(
                        screen.label,
                        modifier = Modifier.wrapContentSize(),
                        fontSize = 11.sp,
                        color = if (selected) Color(0xff33E2E1) else Color(0xff9CA3AF) // Custom text color
                    )

                },
                selected = currentRoute == screen.route,
                onClick = {

                    if (Index in itemsDestinations) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                alwaysShowLabel = true,
                selectedContentColor = Color(0xff33E2E1),
                unselectedContentColor = Color(0xFF3C3C3C) // Color for unselected icon


            )
        }
    }
}






