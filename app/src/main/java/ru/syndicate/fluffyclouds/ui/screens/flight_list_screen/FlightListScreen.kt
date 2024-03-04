package ru.syndicate.fluffyclouds.ui.screens.flight_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.data.model.FlightCardTag
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.ui.screens.flight_list_screen.components.FlightCard
import ru.syndicate.fluffyclouds.ui.screens.flight_list_screen.components.FlightTopBar
import ru.syndicate.fluffyclouds.ui.screens.home_screen.components.ChipsRow
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightListScreen(
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    flightPair: Pair<TownFlightModel, TownFlightModel> = Pair(
        TownFlightModel(),
        TownFlightModel()
    ),
    dateFlight: Pair<LocalDate?, LocalDate?> = Pair(
        LocalDate.now(),
        LocalDate.now()
    ),
    peopleClassState: PeopleClassState = PeopleClassState(),
    changeSheetContent: (SheetContentState) -> Unit = { },
    navigateToInfoFlight: () -> Unit = { },
    navigateToInfoFlightTransfer: () -> Unit = { },
    clickToBack: () -> Unit = { }
) {

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 120.dp
                )
        ) {

            ChipsRow(
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp
                    )
                    .padding(
                        vertical = 14.dp
                    )
                    .fillMaxWidth(),
                scaffoldState = scaffoldState,
                dateFlight = dateFlight,
                peopleClassState = peopleClassState,
                changeSheetContent = changeSheetContent
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                item {
                    FlightCard(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color.White
                            )
                            .clickable { navigateToInfoFlight() }
                            .padding(12.dp),
                        tagType = FlightCardTag.FASTER
                    )
                }

                item {
                    FlightCard(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color.White
                            )
                            .clickable { navigateToInfoFlight() }
                            .padding(12.dp),
                        tagType = FlightCardTag.CHEAPEST
                    )
                }

                item {
                    FlightCard(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color.White
                            )
                            .clickable { navigateToInfoFlightTransfer() }
                            .padding(12.dp),
                        timeFrom = "09:00",
                        timeTo = "19:00",
                        hoursInRoute = 10,
                        transfers = 1
                    )
                }

                item {
                    FlightCard(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color.White
                            )
                            .clickable { navigateToInfoFlightTransfer() }
                            .padding(12.dp),
                        timeFrom = "09:00",
                        timeTo = "19:00",
                        hoursInRoute = 10,
                        transfers = 2
                    )
                }

                item {
                    FlightCard(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color.White
                            )
                            .clickable { navigateToInfoFlightTransfer() }
                            .padding(12.dp),
                        timeFrom = "09:00",
                        timeTo = "19:00",
                        hoursInRoute = 10,
                        transfers = 3
                    )
                }

                items(20) {
                    FlightCard(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color.White
                            )
                            .clickable { navigateToInfoFlight() }
                            .padding(12.dp)
                    )
                }

                item {
                    Spacer(
                        modifier = Modifier
                            .height(100.dp)
                    )
                }
            }
        }

        FlightTopBar(
            modifier = Modifier
                .fillMaxWidth(),
            flightPair = flightPair,
            clickToBack = clickToBack
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewFlightScreen() {
    FlightListScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = BackgroundColor
            )
    )
}