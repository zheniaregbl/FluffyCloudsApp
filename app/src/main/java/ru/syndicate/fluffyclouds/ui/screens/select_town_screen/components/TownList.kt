package ru.syndicate.fluffyclouds.ui.screens.select_town_screen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText

@SuppressLint("MutableCollectionMutableState")
@Composable
fun TownList(
    modifier: Modifier = Modifier,
    state: MutableState<String> = mutableStateOf(""),
    onClickTown: (TownFlightModel) -> Unit = { }
) {

    val list = listOf(
        TownFlightModel(
            town = "Уфа",
            shortTownName = "УФА",
            iata = "UFA",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Москва",
            shortTownName = "МСК",
            iata = "DME",
            airport = "Домодедово",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Москва",
            shortTownName = "МСК",
            iata = "VKO",
            airport = "Внуково",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Москва",
            shortTownName = "МСК",
            iata = "ZIA",
            airport = "Жуковский",
            country = "Россия"
        ),
        TownFlightModel(
            town = "Москва",
            shortTownName = "МСК",
            iata = "SVO",
            airport = "Шереметьево",
            country = "Россия"
        )
    )

    val listTown = ArrayList<TownFlightModel>()

    list.forEach {
        listTown.add(it)
    }

    /*var filteredTown: ArrayList<TownFlightModel>*/
    var filteredTown by remember {
        mutableStateOf(
            ArrayList<TownFlightModel>()
        )
    }

    Box(
        modifier = modifier
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
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

        if (filteredTown.isEmpty())
            Column(
                modifier = Modifier
                    .padding(
                        top = 100.dp
                    )
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    modifier = Modifier
                        .size(30.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_search),
                    contentDescription = null,
                    tint = GrayText
                )

                Spacer(
                    modifier = Modifier
                        .height(14.dp)
                )

                Text(
                    text = "Ничего не нашли",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = BlackText
                )

                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                )

                Text(
                    text = "Проверьте правильно ли вы\nнаписали название",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText,
                    textAlign = TextAlign.Center
                )
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