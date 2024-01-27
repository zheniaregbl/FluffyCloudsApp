package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import java.time.LocalDate
import java.time.Month

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipsRow(
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    dateFlight: Pair<LocalDate?, LocalDate?> = Pair(null, null),
    peopleClassState: PeopleClassState = PeopleClassState(),
    changeSheetContent: (SheetContentState) -> Unit = { }
) {

    val scope = rememberCoroutineScope()

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        item {
            SearchChip(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(
                        color = Color.White
                    )
                    .clickable {
                        scope.launch {
                            changeSheetContent(SheetContentState.CALENDAR)
                            delay(80)
                            scaffoldState.bottomSheetState.expand()
                        }
                    }
                    .padding(14.dp),
                textColor = if (dateFlight.first == null) GrayText else BlackText,
                icon = R.drawable.svg_calendar,
                text = getChipText(dateFlight)
            )
        }

        item {
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
        }

        item {

            val quantity = peopleClassState.adultCount + peopleClassState.childrenCount + peopleClassState.infantCount

            val classFlight = when (peopleClassState.classState) {
                0 -> "Эконом"
                1 -> "Комфорт"
                2 -> "Бизнес"
                3 -> "Первый класс"
                else -> "Первый класс"
            }

            SearchChip(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(
                        color = Color.White
                    )
                    .clickable {
                        scope.launch {
                            changeSheetContent(SheetContentState.PEOPLE)
                            delay(80)
                            scaffoldState.bottomSheetState.expand()
                        }
                    }
                    .padding(14.dp),
                textColor = BlackText,
                icon = R.drawable.svg_people,
                text = "$quantity, $classFlight"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewChipsRow() {
    ChipsRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp
            )
    )
}

private fun getChipText(dateFlight: Pair<LocalDate?, LocalDate?>): String {
    if (dateFlight.first == null)
        return "Даты"

    val dateTextFrom = "${dateFlight.first!!.dayOfMonth} ${getTextMonth(dateFlight.first!!.month)}"

    if (dateFlight.second == null)
        return dateTextFrom

    val dateTextTo = "${dateFlight.second!!.dayOfMonth} ${getTextMonth(dateFlight.second!!.month)}"

    return "$dateTextFrom | $dateTextTo"
}

private fun getTextMonth(month: Month) = when (month) {
    Month.JANUARY -> "янв"
    Month.FEBRUARY -> "фев"
    Month.MARCH -> "мар"
    Month.APRIL -> "апр"
    Month.MAY -> "май"
    Month.JUNE -> "июн"
    Month.JULY -> "июл"
    Month.AUGUST -> "авг"
    Month.SEPTEMBER -> "сен"
    Month.OCTOBER -> "окт"
    Month.NOVEMBER -> "ноя"
    Month.DECEMBER -> "дек"
    else -> "янв"
}