package com.narsha.bubblechat.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.narsha.bubblechat.ui.feature.friend.Friend
import com.narsha.bubblechat.ui.theme.DarkestBlack
import com.narsha.bubblechat.ui.theme.pretendard

@Composable
fun FriendItem(friend: Friend) {
    Row {
        Box {
            AsyncImage(
                model = friend.photoPath,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column {
            Text(text = friend.name, color = DarkestBlack ,style = TextStyle(fontFamily = pretendard, fontWeight = ))
        }
    }
}