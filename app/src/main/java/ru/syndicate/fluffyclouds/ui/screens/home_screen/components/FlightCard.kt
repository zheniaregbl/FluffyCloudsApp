package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.CustomGreen
import ru.syndicate.fluffyclouds.ui.theme.DashLineColor
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.utils.DottedShape

@Composable
fun FlightCard(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                )
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp
                        )
                    )
                    .height(14.dp)
                    .background(
                        color = Color.White
                    )
            )

            Row(
                modifier = Modifier
                    .background(
                        color = Color.White
                    )
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "МСК",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText
                )

                Text(
                    text = "МСК",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText
                )
            }

            Row(
                modifier = Modifier
                    .background(
                        color = Color.White
                    )
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Москва",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = GrayText
                )

                Text(
                    text = "Москва",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = GrayText
                )
            }

            Row(
                modifier = Modifier
                    .background(
                        color = Color.White
                    )
                    .padding(
                        top = 10.dp
                    )
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "10:00",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText
                )

                Text(
                    text = "10:00",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText
                )
            }

            Row(
                modifier = Modifier
                    .background(
                        color = Color.White
                    )
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "10 ЯНВ 2023",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = GrayText
                )

                Text(
                    text = "10 ЯНВ 2023",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = GrayText
                )
            }

            Row(
                modifier = Modifier
                    .background(
                        color = Color.White
                    )
                    .fillMaxWidth()
                    .padding(
                        vertical = 20.dp,
                        horizontal = 20.dp
                    )
            ) {
                FlightCardTag(
                    textTag = "Дешёвый",
                    color = CustomGreen
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    )
                    .height(30.dp)
                    .background(
                        color = Color.White
                    ),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                        .padding(
                            start = 15.dp
                        )
                        .background(
                            color = DashLineColor,
                            shape = DottedShape(step = 10.dp)
                        )
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(
                        start = 5.dp
                    )
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(
                        color = BackgroundColor
                    )
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(
                        end = 5.dp
                    )
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(
                        color = BackgroundColor
                    )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                )
        ) {

            Row(
                modifier = Modifier
                    .background(
                        color = Color.White
                    )
                    .padding(
                        top = 10.dp
                    )
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {

                    Text(
                        text = "Компания",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = GrayText
                    )

                    Text(
                        text = "Аэрофлот",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )
                }

                Text(
                    text = "2 000₽",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .height(14.dp)
                    .background(
                        color = Color.White
                    )
            )
        }
    }
}

@Composable
fun FlightCardTag(
    textTag: String,
    color: Color
) {

    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(8.dp)
            )
            .background(
                color = color
            )
            .padding(
                vertical = 6.dp,
                horizontal = 16.dp
            ),
    ) {

        Text(
            text = textTag,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewFlightCard() {
    FlightCard(
        modifier = Modifier
            .fillMaxWidth()
    )
}