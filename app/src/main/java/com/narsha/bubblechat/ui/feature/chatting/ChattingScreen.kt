package com.narsha.bubblechat.ui.feature.chatting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.narsha.bubblechat.ui.theme.DarkestBlack
import com.narsha.bubblechat.ui.theme.pretendard
import dgsw.proj.bubblechat.R

@Composable
fun ChattingScreen(viewModel: ChattingViewModel, navigationRequsted: (String) -> Unit) {
    Column {
        Header()
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(60.dp)
    ) {
        Text(
            text = "채팅",
            color = DarkestBlack,
            style = TextStyle(
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Icon(
            painter = painterResource(id = R.drawable.addchat), contentDescription = "",
            modifier = Modifier
                .clickable {

                },
        )
    }
}