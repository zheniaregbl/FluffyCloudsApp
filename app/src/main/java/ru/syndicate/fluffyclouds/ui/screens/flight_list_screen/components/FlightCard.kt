package ru.syndicate.fluffyclouds.ui.screens.flight_list_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.data.model.FlightCardTag
import ru.syndicate.fluffyclouds.ui.common.CompanyImage
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.CustomGreen
import ru.syndicate.fluffyclouds.ui.theme.CustomPurple
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import java.text.DecimalFormat

@Composable
fun FlightCard(
    modifier: Modifier = Modifier,
    cost: Int = 10000,
    timeFrom: String = "10:00",
    timeTo: String = "14:00",
    hoursInRoute: Int = 4,
    transfers: Int = 0,
    tagType: FlightCardTag = FlightCardTag.NONE
) {

    Box {

        Column(
            modifier = Modifier
                .padding(
                    top = if (tagType != FlightCardTag.NONE) 14.dp else 0.dp
                )
                .composed { modifier },
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Text(
                text = "${DecimalFormat("#,###").format(cost).replace(",", " ")} ₽",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = BlackText
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Top
            ) {

                Box {

                    CompanyImage(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                color = Color.White
                            )
                            .padding(2.dp),
                        url = "https://nqzgkeopbshaepraaexh.supabase.co/storage/v1/object/public/company/company_aeroflot.png",
                        imageSize = 24.dp
                    )

                    if (transfers != 0) {

                        CompanyImage(
                            modifier = Modifier
                                .padding(
                                    top = 16.dp
                                )
                                .clip(CircleShape)
                                .background(
                                    color = Color.White
                                )
                                .padding(2.dp),
                            url = "https://nqzgkeopbshaepraaexh.supabase.co/storage/v1/object/public/company/company_s7.png",
                            imageSize = 24.dp
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.Top
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {

                        Text(
                            text = timeFrom,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = BlackText
                        )

                        Text(
                            text = "SVO",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = GrayText
                        )
                    }

                    Text(
                        text = "—",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = GrayText
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {

                        Text(
                            text = timeTo,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = BlackText
                        )

                        Text(
                            text = "AER",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = GrayText
                        )
                    }
                }

                if (transfers == 0) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Text(
                            text = "Прямой рейс",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = BlackText
                        )

                        Text(
                            text = "4ч в пути",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = BlackText
                        )
                    }
                } else {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {

                            Text(
                                text = "${hoursInRoute}ч в пути",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = BlackText
                            )

                            Text(
                                text = "/",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = GrayText
                            )

                            Text(
                                text = when {
                                    transfers % 100 in 11..20 -> "$transfers пересадок"
                                    transfers % 10 == 1 -> "$transfers пересадка"
                                    transfers % 10 in 2..4 -> "$transfers пересадки"
                                    else -> "$transfers пересадок"
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = BlackText
                            )
                        }

                        for (i in 0 until transfers) {

                            Text(
                                text = "1ч Стамбул",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = GrayText
                            )
                        }
                    }
                }
            }
        }

        if (tagType != FlightCardTag.NONE)
            Text(
                modifier = Modifier
                    .padding(
                        start = 8.dp
                    )
                    .clip(RoundedCornerShape(100.dp))
                    .background(
                        color = when (tagType) {
                            FlightCardTag.CHEAPEST -> CustomGreen
                            FlightCardTag.FASTER -> CustomPurple
                            else -> Color.Transparent
                        }
                    )
                    .padding(
                        vertical = 2.dp,
                        horizontal = 6.dp
                    ),
                text = when (tagType) {
                    FlightCardTag.CHEAPEST -> "Самый дешёвый"
                    FlightCardTag.FASTER -> "Самый быстрый"
                    else -> ""
                },
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color.White
            )
    }
}

@Preview
@Composable
fun PreviewFlightCard() {
    FlightCard(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(
                color = Color.White
            )
            .padding(12.dp)
    )
}

@Preview
@Composable
fun PreviewFlightCardWithTransfers() {
    FlightCard(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(
                color = Color.White
            )
            .padding(12.dp),
        timeFrom = "09:00",
        timeTo = "19:00",
        hoursInRoute = 10,
        transfers = 2
    )
}