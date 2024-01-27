package ru.syndicate.fluffyclouds.ui.screens.flight_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    clickToBack: () -> Unit = { }
) {

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 134.dp
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
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                item {
                    FlightCard(
                        modifier = Modifier
                            .fillMaxWidth(),
                        isCheapest = true
                    )
                }

                items(5) {
                    FlightCard(
                        modifier = Modifier
                            .fillMaxWidth(),
                        isCheapest = false
                    )
                }

                item {
                    Spacer(
                        modifier = Modifier
                            .height(120.dp)
                    )
                }
            }
        }

        FlightTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White
                ),
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