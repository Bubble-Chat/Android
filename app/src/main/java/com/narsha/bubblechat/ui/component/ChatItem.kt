package com.narsha.bubblechat.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.narsha.bubblechat.ui.feature.friend.Friend
import com.narsha.bubblechat.ui.theme.DarkestBlack
import com.narsha.bubblechat.ui.theme.LighterBlack
import com.narsha.bubblechat.ui.theme.pretendard
import dgsw.proj.bubblechat.R

@Composable
fun ChatItem(friend: Friend) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(60.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
        ) {
            AsyncImage(
                model = friend.photoPath,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 16.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(start = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = friend.name,
                    color = DarkestBlack,
                    style = TextStyle(
                        fontFamily = pretendard,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = "상태메시지",
                    color = LighterBlack,
                    maxLines = 1,
                    style = TextStyle(
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp
                    )
                )
            }
        }
        Image(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp),
            painter = painterResource(id = R.drawable.chat1vs1),
            contentDescription = null
        )
    }
}