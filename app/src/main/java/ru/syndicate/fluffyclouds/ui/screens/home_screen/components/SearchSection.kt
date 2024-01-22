package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor

@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    searchTown: Pair<TownFlightModel, TownFlightModel> = Pair(
        TownFlightModel(
            town = ""
        ),
        TownFlightModel(
            town = ""
        )
    ),
    onClickFromField: () -> Unit = { },
    onClickToField: () -> Unit = { },
    onClickSwap: () -> Unit = { }
) {

    Column(
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp
                        )
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            color = Color.White
                        )
                ) {

                    TownField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(6.dp)
                            )
                            .background(
                                color = Color.White
                            )
                            .clickable { onClickFromField() }
                            .padding(18.dp),
                        town = searchTown.first.town,
                        airport = searchTown.first.airport,
                        hintText = "Откуда"
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp
                        )
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            color = Color.White
                        )
                ) {

                    TownField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(6.dp)
                            )
                            .background(
                                color = Color.White
                            )
                            .clickable { onClickToField() }
                            .padding(18.dp),
                        town = searchTown.second.town,
                        airport = searchTown.second.airport,
                        hintText = "Куда"
                    )
                }
            }

            SwapButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(
                        end = 40.dp
                    )
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(
                        color = BackgroundColor
                    ),
                onClick = { onClickSwap() }
            )
        }
    }
}

@Preview
@Composable
fun PreviewSearchSection() {
    SearchSection(
        modifier = Modifier
            .fillMaxWidth()
    )
}