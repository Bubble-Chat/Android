package com.narsha.bubblechat.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.narsha.bubblechat.ui.feature.StartScreen
import com.narsha.bubblechat.ui.feature.StartViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.START.route
    ) {
        composable(Route.START.route) {
            StartDestination(navController = navController)
        }
    }
}

@Composable
private fun StartDestination(navController: NavController) {
    val viewModel: StartViewModel = hiltViewModel()
    StartScreen(viewModel = viewModel)
}

sealed class Route(val route: String) {
    object MAIN : Route("MAIN")
    object START : Route("START")
    object PROFILE : Route("PROFILE")

}