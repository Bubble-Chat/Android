package com.narsha.bubblechat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navigationDepth1() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.MAIN
    ) {
        composable(Route.MAIN) {
            
        }
    }
}

object Route {
    const val MAIN = "MAIN"
    const val START = "START"
    const val PROFILE = "PROFILE"
    const val
}