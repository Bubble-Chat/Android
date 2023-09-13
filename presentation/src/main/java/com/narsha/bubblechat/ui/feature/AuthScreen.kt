package com.narsha.bubblechat.ui.feature

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.narsha.bubblechat.R
import com.narsha.bubblechat.ui.theme.DarkGray
import com.narsha.bubblechat.ui.theme.PrimaryPurple
import com.narsha.bubblechat.ui.theme.PrimarySkyBlue
import com.narsha.bubblechat.ui.theme.pretendard
import com.narsha.bubblechat.util.dpToSp

@Composable
fun StartScreen(
) {
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
                .padding(horizontal = 28.dp, vertical = 28.dp)
                .fillMaxWidth()
                .height(52.dp)
                .border(BorderStroke(1.dp, DarkGray))
                .clickable {

                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.googleicon),
                    contentDescription = null
                )
                Text(
                    text = "구글로 로그인하기",
                    color = DarkGray,
                    style = TextStyle(
                        fontFamily = pretendard,
                        fontSize = dpToSp(dp = 24.dp),
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewStartScreen() {
    StartScreen()
}