package com.narsha.bubblechat.ui.feature.appbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.narsha.bubblechat.ui.theme.LightPurple
import com.narsha.bubblechat.ui.theme.LighterBlack
import com.narsha.bubblechat.util.dpToSp
import dgsw.proj.bubblechat.R

sealed class BottomNavItem(val name: String, val icon: Int, val route: String) {
    object Friend : BottomNavItem(name = "친구", icon = R.drawable.friend, FRIEND)
    object Chatting : BottomNavItem(name = "채팅", icon = R.drawable.chatting, CHATTING)
    object Setting : BottomNavItem(name = "설정", icon = R.drawable.setting, SETTING)
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
                        contentDescription = item.name,
                        modifier = Modifier
                            .size(26.dp),
                        tint = if (currentRoute == item.route) LightPurple else LighterBlack
                    )
                },
                label = {
                    Text(
                        text = item.name,
                        style = TextStyle(fontSize = dpToSp(9.dp)),
                        color = when (currentRoute) {
                            item.route -> LightPurple
                            else -> LighterBlack
                        }
                    )
                },
                selectedContentColor = LightPurple,
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