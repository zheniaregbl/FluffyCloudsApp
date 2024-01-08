package ru.syndicate.fluffyclouds.ui.sheet_content.people_class_content.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.ui.theme.BorderRadio
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun CustomRadioButton(
    size: Dp = 24.dp,
    isSelected: Boolean = false
) {

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(size)
            .background(
                color = if (isSelected) MainBlue else BorderRadio
            ),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(size - 2.dp)
                .background(
                    color = if (isSelected) MainBlue else Color.White
                ),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(size - 12.dp)
                    .background(
                        color = Color.White
                    )
            )
        }
    }
}

@Preview
@Composable
fun PreviewCustomRadioButton() {
    CustomRadioButton(
        isSelected = false
    )
}