package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    isVisibleSearchColumn: Boolean = false,
    onSearchClick: () -> Unit = { }
) {

    Box(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp,
                    bottom = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = buildAnnotatedString {

                    withStyle(
                        style = SpanStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                            color = BlackText
                        )
                    ) {
                        append("Fluffy")
                    }

                    withStyle(
                        style = SpanStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                            color = MainBlue
                        )
                    ) {
                        append("Clouds")
                    }
                }
            )

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (isVisibleSearchColumn) MainBlue else GrayText
                    )
                    .clickable { onSearchClick() },
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(
                            color = if (isVisibleSearchColumn) MainBlue else Color.White
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_search),
                        contentDescription = null,
                        tint = if (isVisibleSearchColumn) Color.White else GrayText
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeTopBar() {
    HomeTopBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            )
    )
}