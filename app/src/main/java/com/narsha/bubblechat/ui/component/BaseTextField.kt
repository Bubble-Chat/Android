package com.narsha.bubblechat.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.narsha.bubblechat.ui.theme.LighterBlack
import com.narsha.bubblechat.ui.theme.pretendard

@Composable
fun BaseTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        singleLine = true,
        value = value,
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            Box(modifier = Modifier.padding(start = 16.dp)) {
                if (value.isEmpty()) {
                    Text(
                        placeHolder,
                        color = LighterBlack,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                    )
                }
                innerTextField()
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewStartScreen() {
    BaseTextField(value = "null", placeHolder = "null") {}
}
