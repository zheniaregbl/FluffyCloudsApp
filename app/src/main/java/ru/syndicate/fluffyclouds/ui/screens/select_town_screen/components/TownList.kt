package ru.syndicate.fluffyclouds.ui.screens.select_town_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.data.model.TownFlightModel

@Composable
fun TownList(
    modifier: Modifier = Modifier,
    state: MutableState<String> = mutableStateOf(""),
    onClickTown: (TownFlightModel) -> Unit = { }
) {

    val list = listOf(
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Уфа",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Москва",
            iata = "DME",
            airport = "Домодедово",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Москва",
            iata = "VKO",
            airport = "Внуково",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Москва",
            iata = "ZIA",
            airport = "Жуковский",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Москва",
            iata = "SVO",
            airport = "Шереметьево",
            country = "Россия"
        )
    )

    val listTown = ArrayList<TownFlightModel>()

    list.forEach {
        listTown.add(it)
    }

    var filteredTown: ArrayList<TownFlightModel>

    LazyColumn(
        modifier = modifier
    ) {
        filteredTown = if (state.value.isEmpty()) {
            listTown
        } else {
            val resultList = ArrayList<TownFlightModel>()

            for (town in listTown) {
                if (town.town.lowercase().contains(state.value.lowercase()))
                    resultList.add(town)
            }

            resultList
        }

        items(filteredTown) { town ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                TownListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            color = Color.White
                        )
                        .clickable { onClickTown(town) }
                        .padding(10.dp),
                    model = town
                )

                if (filteredTown.indexOf(town) != filteredTown.lastIndex)
                    Spacer(
                        modifier = Modifier
                            .height(6.dp)
                    )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTownList() {
    TownList(
        modifier = Modifier
            .fillMaxWidth()
    )
}