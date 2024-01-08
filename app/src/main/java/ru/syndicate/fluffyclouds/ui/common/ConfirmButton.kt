package ru.syndicate.fluffyclouds.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.ui.theme.CustomGreen

@Composable
fun ConfirmButton(
    modifier: Modifier = Modifier,
    text: String = "Выбрать"
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewConfirmButton() {
    ConfirmButton(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(
                color = CustomGreen
            )
            .padding(
                vertical = 16.dp
            )
    )
}