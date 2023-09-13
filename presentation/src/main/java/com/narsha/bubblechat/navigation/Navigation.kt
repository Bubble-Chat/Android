package com.narsha.bubblechat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.MAIN.route
    ) {
        composable(Route.MAIN.route) {

        }
    }
}

sealed class Route(val route: String) {
    object MAIN : Route("MAIN")
    object START : Route("START")
    object PROFILE : Route("PROFILE")

}