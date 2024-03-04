package ru.syndicate.fluffyclouds.ui.screens.flight_list_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun FlightTopBar(
    modifier: Modifier = Modifier,
    flightPair: Pair<TownFlightModel, TownFlightModel> = Pair(
        TownFlightModel(),
        TownFlightModel()
    ),
    clickToBack: () -> Unit = { }
) {

    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        color = Color.White
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp,
                    bottom = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) { clickToBack() },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Icon(
                        modifier = Modifier
                            .size(18.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_arrow_back),
                        contentDescription = null,
                        tint = MainBlue
                    )

                    Text(
                        text = "Назад",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium,
                        color = MainBlue
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(6.dp)
            )

            Text(
                text = "${flightPair.first.shortTownName} (${flightPair.first.iata})" +
                        " - ${flightPair.second.shortTownName} (${flightPair.second.iata})",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 26.sp,
                fontWeight = FontWeight.Medium,
                color = BlackText
            )

            Text(
                text = "${flightPair.first.town},${flightPair.first.country}" +
                        " - ${flightPair.second.town},${flightPair.second.country}",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = GrayText
            )
        }
    }
}

@Preview
@Composable
fun PreviewFlightTopBar() {
    FlightTopBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            )
    )
}