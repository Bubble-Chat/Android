package com.narsha.bubblechat.ui.feature.start

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.narsha.bubblechat.navigation.Route
import com.narsha.bubblechat.ui.theme.PrimaryPurple
import com.narsha.bubblechat.ui.theme.PrimarySkyBlue
import com.narsha.bubblechat.ui.theme.GoogleSignInColor
import com.narsha.bubblechat.ui.theme.roboto
import com.narsha.bubblechat.util.dpToSp
import dgsw.proj.bubblechat.R

@Composable
fun StartScreen(
    viewModel: StartViewModel,
    navigation: (String) -> Unit
) {
    val startForResult =
        rememberLauncherForActivityResult(GoogleApiContract()) { result ->
            if (result != null) {
                when {
                    result.isSuccessful -> {
                        viewModel.postIdToken(
                            email = "wyk172899@gmail,com",
                            name = "우영기",
                            navigation = { navigation(Route.MAIN.route) })
                        Log.d("성공", result.result.email.toString())
//                        result.result.email?.let { email ->
//                            result.result.displayName?.let { name ->
//                                viewModel.postIdToken(email = email, name = name)
//                            }
//                        }
                    }

                    result.isComplete -> {
                        Log.d("complete", result.result.idToken.toString())
                    }

                    result.isCanceled -> {
                        Log.d("cancled", "하")
                    }
                }
            }
        }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(PrimarySkyBlue, PrimaryPurple)))
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.splashart),
            contentDescription = "bubblechat"
        )

        Surface(
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(28.dp)
                .fillMaxWidth()
                .height(40.dp)
                .clickable {
                    startForResult.launch(1)
                },
            shape = RoundedCornerShape(50.dp),
            shadowElevation = 5.dp
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Image(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.googleicon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Google계정으로 가입",
                    color = GoogleSignInColor,
                    style = TextStyle(
                        fontFamily = roboto,
                        fontSize = dpToSp(dp = 14.dp),
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewStartScreen() {
    StartScreen(hiltViewModel(),{})
}