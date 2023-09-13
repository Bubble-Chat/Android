package com.narsha.bubblechat.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.narsha.bubblechat.navigation.Navigation
import com.narsha.bubblechat.ui.theme.BubblechatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BubblechatTheme {
                Navigation()
            }
        }
    }
}



