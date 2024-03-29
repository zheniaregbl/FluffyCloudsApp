package ru.syndicate.fluffyclouds.ui.screens.profile_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.ui.theme.BlackText

@Composable
fun ProfileTopBar(
    modifier: Modifier = Modifier,
    userName: String = "Иван Иванов"
) {

    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        color = Color.White
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp,
                    bottom = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {

            Text(
                text = userName,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 26.sp,
                fontWeight = FontWeight.Medium,
                color = BlackText
            )
        }
    }
}

@Preview
@Composable
fun PreviewProfileTopBar() {
    ProfileTopBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            )
    )
}