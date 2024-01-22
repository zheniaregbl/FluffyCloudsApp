package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText

@Composable
fun TownField(
    modifier: Modifier = Modifier,
    town: String = "",
    airport: String = "",
    hintText: String = "Откуда"
) {

    Box(
        modifier = modifier
    ) {

        Text(
            text = if (town.isEmpty()) hintText
                else "$town, $airport",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = if (town.isEmpty()) GrayText else BlackText
        )
    }
}

@Preview
@Composable
fun PreviewTownField() {
    TownField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(6.dp)
            )
            .background(
                color = Color.White
            )
            .padding(18.dp)
    )
}