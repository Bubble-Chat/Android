package com.narsha.bubblechat

import android.app.Activity
import android.hardware.camera2.CaptureFailure
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.narsha.bubblechat.ui.theme.BubblechatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BubblechatTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen() {
    val color1 = colorResource(id = R.color.skyBlue)
    val color2 = colorResource(id = R.color.purple)
    val brush = Brush.verticalGradient(
        colors = listOf(
            color1,
            color2
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush),
        contentAlignment = Alignment.Center
    ) {
        LogoImage()
   }
}
@Composable
fun LogoImage() {
    Image(
        painter = painterResource(id = R.drawable.bubblechat),
        contentDescription = null
    )
}
@Composable
fun GoogleSignInButton() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BubblechatTheme {
        MainScreen()
    }
}

private fun getGoogleLoginAuth(): GoogleSignInClient {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
        .requestEmail()
        // TODO(".requestIdToken(getString(gcp_id))")
        .requestId()
        .build()
    return GoogleSignIn.getClient(Activity(), gso)
}


