package com.narsha.bubblechat.navigation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.narsha.bubblechat.ui.feature.appbar.BottomNavigationView
import com.narsha.bubblechat.ui.feature.chatting.ChattingScreen
import com.narsha.bubblechat.ui.feature.chatting.ChattingViewModel
import com.narsha.bubblechat.ui.feature.friend.FriendScreen
import com.narsha.bubblechat.ui.feature.friend.FriendViewModel
import com.narsha.bubblechat.ui.feature.setting.SettingScreen
import com.narsha.bubblechat.ui.feature.setting.SettingViewModel
import com.narsha.bubblechat.ui.feature.start.StartScreen
import com.narsha.bubblechat.ui.feature.start.StartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        bottomBar = {
            when (currentDestination?.route) {
                Route.FRIEND.route, Route.CHATTING.route, Route.SETTING.route -> BottomNavigationView(
                    navController = navController,
                    currentRoute = currentDestination.route
                )
            }
        },
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Route.START.route
        ) {
            composable(Route.START.route) {
                StartDestination(navController = navController)
            }
            composable(Route.FRIEND.route) {
                FriendDestination(navController = navController)
            }
            composable(Route.CHATTING.route) {
                FriendDestination(navController = navController)
            }
            composable(Route.SETTING.route) {
                FriendDestination(navController = navController)
            }
        }
    }

}

@Composable
private fun StartDestination(navController: NavController) {
    val viewModel: StartViewModel = hiltViewModel()
    StartScreen(viewModel = viewModel) {
        navController.navigate(it)
    }
}
@Composable
private fun FriendDestination(navController: NavController) {
    val viewModel: FriendViewModel = hiltViewModel()
    FriendScreen(viewModel = viewModel) {
        navController.navigate(it)
    }
}
@Composable
private fun ChattingDestination(navController: NavController) {
    val viewModel: ChattingViewModel = hiltViewModel()
    ChattingScreen(viewModel = viewModel) {
        navController.navigate(it)
    }
}
@Composable
private fun SettingDestination(navController: NavController) {
    val viewModel: SettingViewModel = hiltViewModel()
    SettingScreen(viewModel = viewModel) {
        navController.navigate(it)
    }
}



sealed class Route(val route: String) {
    object FRIEND : Route("FRIEND")
    object CHATTING : Route("CHATTING")
    object SETTING : Route("SETTING")
    object START : Route("START")
    object PROFILE : Route("PROFILE")

}