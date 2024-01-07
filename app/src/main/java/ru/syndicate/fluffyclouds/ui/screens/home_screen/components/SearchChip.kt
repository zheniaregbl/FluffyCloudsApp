package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.theme.GrayText

@Composable
fun SearchChip(
    modifier: Modifier = Modifier,
    textColor: Color = GrayText,
    icon: Int = R.drawable.svg_calendar,
    text: String = "Даты"
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            tint = textColor
        )

        Spacer(
            modifier = Modifier
                .width(6.dp)
        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = textColor
        )
    }
}

@Preview
@Composable
fun PreviewSearchChip() {
    SearchChip(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(
                color = Color.White
            )
            .padding(14.dp)
    )
}