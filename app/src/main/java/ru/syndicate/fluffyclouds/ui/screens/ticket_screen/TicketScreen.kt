package ru.syndicate.fluffyclouds.ui.screens.ticket_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.data.model.TicketFilterState
import ru.syndicate.fluffyclouds.ui.screens.ticket_screen.components.FilterButton
import ru.syndicate.fluffyclouds.ui.screens.ticket_screen.components.TicketCard
import ru.syndicate.fluffyclouds.ui.screens.ticket_screen.components.TicketTopBar
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun TicketScreen(
    modifier: Modifier = Modifier
) {

    var filterState by remember {
        mutableStateOf(TicketFilterState.ALL)
    }

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .padding(
                        top = 90.dp,
                        bottom = 15.dp
                    ),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                FilterButton(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(
                            color = if (filterState == TicketFilterState.ALL) MainBlue
                            else Color.White
                        )
                        .clickable {
                            filterState = TicketFilterState.ALL
                        }
                        .padding(16.dp),
                    textFilter = "Все",
                    isSelected = filterState == TicketFilterState.ALL
                )

                FilterButton(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(
                            color = if (filterState == TicketFilterState.ACTIVE) MainBlue
                            else Color.White
                        )
                        .clickable {
                            filterState = TicketFilterState.ACTIVE
                        }
                        .padding(16.dp),
                    textFilter = "Активные",
                    isSelected = filterState == TicketFilterState.ACTIVE
                )

                FilterButton(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(
                            color = if (filterState == TicketFilterState.INACTIVE) MainBlue
                            else Color.White
                        )
                        .clickable {
                            filterState = TicketFilterState.INACTIVE
                        }
                        .padding(16.dp),
                    textFilter = "Неактивные",
                    isSelected = filterState == TicketFilterState.INACTIVE
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(5) {

                    TicketCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                color = Color.White
                            )
                            .padding(16.dp)
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

        TicketTopBar(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewTicketScreen() {
    TicketScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = BackgroundColor
            )
    )
}