package com.narsha.bubblechat.ui.feature.appbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.narsha.bubblechat.ui.theme.LightBlue
import com.narsha.bubblechat.ui.theme.LighterBlack
import dgsw.proj.bubblechat.R

sealed class BottomNavItem(val icon: Int, val route: String) {
    object Friend : BottomNavItem(icon = R.drawable.friend, FRIEND)
    object Chatting : BottomNavItem(icon = R.drawable.chatting, CHATTING)
    object Setting : BottomNavItem(icon = R.drawable.setting, SETTING)
}

const val FRIEND = "FRIEND"
const val CHATTING = "CHATTING"
const val SETTING = "SETTING"


@Composable
fun BottomNavigationView(
    navController: NavHostController,
    currentRoute: String?
) {
    val items = listOf(
        BottomNavItem.Friend,
        BottomNavItem.Chatting,
        BottomNavItem.Setting
    )

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        backgroundColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(26.dp),
                        tint = if (currentRoute == item.route) LightBlue else LighterBlack
                    )
                },
                selectedContentColor = LightBlue,
                unselectedContentColor = LighterBlack,
                selected = currentRoute == item.route,
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.id.let {
                            popUpTo(it) {
                                saveState = true
                                inclusive = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}