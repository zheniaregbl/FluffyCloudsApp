package ru.syndicate.fluffyclouds.ui.screens.info_flight_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import ru.syndicate.fluffyclouds.ui.screens.home_screen.components.getTextMonth
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import java.time.LocalDate

@Composable
fun FlightRoutePoint(
    time: String = "10:00",
    date: LocalDate = LocalDate.of(
        LocalDate.now().year,
        1,
        10
    ),
    city: String = "Москва",
    airport: String = "Шереметьево",
    iata: String = "SVO",
    isLast: Boolean = false
) {

    Box {

        Row(
            modifier = Modifier
                .padding(
                    start = 6.dp
                )
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
                    .background(
                        color = if (!isLast) GrayText else Color.Transparent
                    )
            )

            Column {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {

                        Text(
                            text = time,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = BlackText
                        )

                        Text(
                            text = "${date.dayOfMonth} ${getTextMonth(date.month)}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = GrayText
                        )
                    }

                    Column {

                        Text(
                            text = city,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = BlackText
                        )

                        Text(
                            text = "$airport, $iata",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = GrayText
                        )
                    }
                }

                if (!isLast)
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )
            }
        }

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(14.dp)
                .background(
                    color = GrayText
                ),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(6.dp)
                    .background(
                        color = Color.White
                    )
            )
        }
    }
}

@Preview
@Composable
fun PreviewFlightRoutePoint() {
    FlightRoutePoint()
}