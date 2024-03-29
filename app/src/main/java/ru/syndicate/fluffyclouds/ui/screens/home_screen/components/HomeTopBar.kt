package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
    canSearch: Boolean = true,
    isEqualsTown: Boolean = false,
    onSearchClick: () -> Unit = { }
) {

    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        color = Color.White
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

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .size(54.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_logo),
                    contentDescription = null
                )

                Column {

                    Text(
                        text = "Fluffy",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = BlackText
                    )

                    Text(
                        text = "Clouds",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MainBlue
                    )
                }
            }

            SearchTopButton(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (canSearch) MainBlue else GrayText
                    ),
                canSearch = canSearch,
                isEqualsTown = isEqualsTown,
                onSearchClick = onSearchClick
            )
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