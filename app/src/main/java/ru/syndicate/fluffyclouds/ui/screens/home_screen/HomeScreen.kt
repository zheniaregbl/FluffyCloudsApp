package ru.syndicate.fluffyclouds.ui.screens.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.data.model.TownCardModel
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.ui.screens.home_screen.components.ChipsRow
import ru.syndicate.fluffyclouds.ui.screens.home_screen.components.DestinationCard
import ru.syndicate.fluffyclouds.ui.screens.home_screen.components.HomeTopBar
import ru.syndicate.fluffyclouds.ui.screens.home_screen.components.SearchSection
import ru.syndicate.fluffyclouds.ui.screens.home_screen.components.TownCard
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.CircleBlack
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    searchTown: Pair<TownFlightModel, TownFlightModel> = Pair(
        TownFlightModel(
            town = ""
        ),
        TownFlightModel(
            town = ""
        )
    ),
    dateFlight: Pair<LocalDate?, LocalDate?> = Pair(null, null),
    peopleClassState: PeopleClassState = PeopleClassState(),
    changeSheetContent: (SheetContentState) -> Unit = { },
    onClickFromField: () -> Unit = { },
    onClickToField: () -> Unit = { },
    onClickSwap: () -> Unit = { },
    searchFlight: () -> Unit = { }
) {

    val listTown = listOf(
        TownCardModel(
            town = "Казань",
            image = R.drawable.kazan
        ),
        TownCardModel(
            town = "Воронеж",
            image = R.drawable.voronezh
        ),
        TownCardModel(
            town = "Москва",
            image = R.drawable.moscow
        ),
        TownCardModel(
            town = "Калининград",
            image = R.drawable.kaliningrad
        ),
        TownCardModel(
            town = "Ростов",
            image = R.drawable.rostov
        ),
        TownCardModel(
            town = "Санкт-Петер.",
            image = R.drawable.spb
        )
    )

    val listDestinationsKazan = listOf(
        TownCardModel(
            town = "Дворец земледельцев",
            image = R.drawable.destination1
        ),
        TownCardModel(
            town = "Башня Cююмбике",
            image = R.drawable.destination2
        ),
        TownCardModel(
            town = "Казанский кремль",
            image = R.drawable.destination3
        ),
    )

    val listDestinationsVoronezh = listOf(
        TownCardModel(
            town = "Воронежский театр\n" +
                    "оперы и балета",
            image = R.drawable.destination4
        ),
        TownCardModel(
            town = "Воронежский \n" +
                    "краеведческий музей",
            image = R.drawable.destination5
        ),
        TownCardModel(
            town = "Воронежский\n" +
                    "океанариум",
            image = R.drawable.destination6
        ),
    )

    Box(
        modifier = modifier
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 74.dp
                ),
            /*state = lazyListState*/
        ) {

            item {
                SearchSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 20.dp
                        ),
                    searchTown = searchTown,
                    onClickFromField = onClickFromField,
                    onClickToField = onClickToField,
                    onClickSwap = onClickSwap
                )
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
            }

            item {
                ChipsRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp
                        ),
                    scaffoldState = scaffoldState,
                    dateFlight = dateFlight,
                    peopleClassState = peopleClassState,
                    changeSheetContent = changeSheetContent
                )
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.svg_compass),
                            contentDescription = null,
                            tint = CircleBlack
                        )

                        Spacer(
                            modifier = Modifier
                                .width(12.dp)
                        )

                        Text(
                            text = "Путешествуйте везде",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = BlackText
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Все",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = MainBlue
                        )

                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                        )

                        Icon(
                            modifier = Modifier
                                .padding(
                                    top = 3.dp
                                ),
                            imageVector = ImageVector.vectorResource(id = R.drawable.svg_arrow),
                            contentDescription = null,
                            tint = MainBlue
                        )
                    }
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(14.dp)
                )
            }

            // ----------------------- List of town's cards -----------------------
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    item {
                        Spacer(
                            modifier = Modifier
                                .width(20.dp)
                        )
                    }

                    items(
                        items = listTown,
                        key = {
                            it.id
                        }
                    ) { model ->

                        TownCard(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    color = Color.White
                                ),
                            townCardModel = model
                        )

                        Spacer(
                            modifier = Modifier
                                .width(10.dp)
                        )
                    }

                    item {
                        Spacer(
                            modifier = Modifier
                                .width(10.dp)
                        )
                    }
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(14.dp)
                )
            }

            // ----------------------- List of destination's cards -----------------------
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.White
                        )
                        .padding(
                            horizontal = 20.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(
                                    top = 14.dp
                                ),
                            text = "Интересные места",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            color = BlackText
                        )

                        Text(
                            modifier = Modifier
                                .padding(
                                    top = 10.dp
                                ),
                            text = "в Казани",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = GrayText
                        )
                    }


                    for (model in listDestinationsKazan) {

                        DestinationCard(
                            modifier = Modifier
                                .fillMaxWidth(),
                            model = model
                        )
                    }

                    Text(
                        text = "в Воронеже",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = GrayText
                    )

                    for (model in listDestinationsVoronezh) {

                        DestinationCard(
                            modifier = Modifier
                                .fillMaxWidth(),
                            model = model
                        )
                    }
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = Color.White
                        )
                )
            }
        }

        HomeTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White
                ),
            canSearch = dateFlight.first != null
                    && searchTown.first.town != ""
                    && searchTown.second.town != "",
            isEqualsTown = searchTown.first.town == searchTown.second.town
                    && searchTown.first.town != "",
            onSearchClick = {
                searchFlight()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = BackgroundColor
            )
    )
}