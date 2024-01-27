package ru.syndicate.fluffyclouds.ui.screens.ticket_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
    textFilter: String = "Все",
    isSelected: Boolean = true
) {

    Box(
        modifier = modifier
    ) {

        Text(
            text = textFilter,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = if (isSelected) Color.White else GrayText
        )
    }
}

@Preview
@Composable
fun PreviewFilterPreview() {
    FilterButton(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(
                color = MainBlue
            )
            .padding(16.dp)
    )
}