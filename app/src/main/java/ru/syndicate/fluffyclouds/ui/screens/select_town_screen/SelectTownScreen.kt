package ru.syndicate.fluffyclouds.ui.screens.select_town_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.ui.common.ConfirmButton
import ru.syndicate.fluffyclouds.ui.screens.select_town_screen.components.SearchTownField
import ru.syndicate.fluffyclouds.ui.screens.select_town_screen.components.TownList
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.ui.theme.CustomGreen

@Composable
fun SelectTownScreen(
    modifier: Modifier = Modifier,
    onClickTown: (TownFlightModel) -> Unit = { }
) {

    val townTextState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        SearchTownField(
            modifier = Modifier
                .fillMaxWidth(),
            textState = townTextState
        )

        TownList(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            state = townTextState,
            onClickTown = onClickTown
        )
    }
}

@Preview
@Composable
fun PreviewSelectTownScreen() {
    SelectTownScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = BackgroundColor
            )
            .padding(
                horizontal = 20.dp,
                vertical = 20.dp
            )
    )
}