package ru.syndicate.fluffyclouds.ui.sheet_content.calendar_content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalendarContent(
    modifier: Modifier = Modifier
) {
    
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Календарь")
    }
}

@Preview
@Composable
fun PreviewCalendarContent() {
    CalendarContent(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    )
}