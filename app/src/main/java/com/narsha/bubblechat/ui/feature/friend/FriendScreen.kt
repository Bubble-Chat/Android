package com.narsha.bubblechat.ui.feature.friend

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.narsha.bubblechat.ui.component.FriendItem
import com.narsha.bubblechat.ui.theme.DarkestBlack
import com.narsha.bubblechat.ui.theme.pretendard
import dgsw.proj.bubblechat.R

@Composable
fun FriendScreen(viewModel: FriendViewModel, navigationRequsted: (String) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {
        val friendList by viewModel.friend.collectAsState()
        Header()
        friendList?.let {
            Body(modifier = Modifier.weight(1f), friend = it)
        }?: kotlin.run {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
private fun Header() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(60.dp)) {
        Text(
            text = "친구",
            color = DarkestBlack,
            style = TextStyle(
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Icon(painter = painterResource(id = R.drawable.addfriend), contentDescription = "")
    }
}

@Composable
private fun Body(modifier: Modifier,friend: List<FriendResponse>) {
    LazyColumn(modifier = modifier) {
        items(friend) {
            FriendItem(friend = it.friend)
        }
    }
}