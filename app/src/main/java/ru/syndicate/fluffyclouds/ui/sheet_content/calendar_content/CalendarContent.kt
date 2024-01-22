package ru.syndicate.fluffyclouds.ui.sheet_content.calendar_content

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.syndicate.fluffyclouds.ui.common.ConfirmButton
import ru.syndicate.fluffyclouds.ui.sheet_content.calendar_content.components.Calendar
import ru.syndicate.fluffyclouds.ui.sheet_content.calendar_content.components.SelectorDate
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.CustomGreen
import ru.syndicate.fluffyclouds.ui.theme.MainBlue
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun CalendarContent(
    modifier: Modifier = Modifier,
    dateFlight: Pair<LocalDate?, LocalDate?> = Pair(null, null),
    onConfirmClick: (LocalDate?, LocalDate?) -> Unit = { _: LocalDate?, _: LocalDate? ->
    },
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState()
) {

    val scope = rememberCoroutineScope()

    val selectDateFrom = remember {
        mutableStateOf(dateFlight.first)
    }
    val selectDateTo = remember {
        mutableStateOf(dateFlight.second)
    }

    var selectorState by remember {
        mutableIntStateOf(0)
    }

    val weeks = getWeeksFromStartDate(
        LocalDate.of(LocalDate.now().year, Month.JANUARY, 1),
        78
    )

    val months = getMonthsFromWeeks(weeks)

    val pagerMonthStateSavedFrom = remember {
        mutableIntStateOf(getCurrentMonth(months, LocalDate.now()))
    }
    val pagerMonthStateSavedTo = remember {
        mutableIntStateOf(getCurrentMonth(months, LocalDate.now()))
    }

    val monthValueFrom = remember {
        mutableStateOf(
            if (dateFlight.first == null) LocalDate.now().month else dateFlight.first!!.month
        )
    }
    val monthValueTo = remember {
        mutableStateOf(
            when {

                dateFlight.second == null && selectDateFrom.value == null -> LocalDate.now().month

                dateFlight.second == null -> selectDateFrom.value!!.month

                else -> dateFlight.second!!.month
            }
        )
    }

    val monthTextFrom = remember {
        mutableStateOf(
            when (
                selectDateFrom.value?.month ?: LocalDate.now().month
            ) {
                Month.JANUARY -> "Январь"
                Month.FEBRUARY -> "Февраль"
                Month.MARCH -> "Март"
                Month.APRIL -> "Апрель"
                Month.MAY -> "Май"
                Month.JUNE -> "Июнь"
                Month.JULY -> "Июль"
                Month.AUGUST -> "Август"
                Month.SEPTEMBER -> "Сентябрь"
                Month.OCTOBER -> "Октябрь"
                Month.NOVEMBER -> "Ноябрь"
                Month.DECEMBER -> "Декабрь"
                else -> "Январь"
            }
        )
    }
    val monthTextTo = remember {
        mutableStateOf(
            when (
                selectDateTo.value?.month ?: LocalDate.now().month
            ) {
                Month.JANUARY -> "Январь"
                Month.FEBRUARY -> "Февраль"
                Month.MARCH -> "Март"
                Month.APRIL -> "Апрель"
                Month.MAY -> "Май"
                Month.JUNE -> "Июнь"
                Month.JULY -> "Июль"
                Month.AUGUST -> "Август"
                Month.SEPTEMBER -> "Сентябрь"
                Month.OCTOBER -> "Октябрь"
                Month.NOVEMBER -> "Ноябрь"
                Month.DECEMBER -> "Декабрь"
                else -> "Январь"
            }
        )
    }

    val yearTextFrom = remember {
        mutableIntStateOf(selectDateFrom.value?.year ?: LocalDate.now().year)
    }
    val yearTextTo = remember {
        mutableIntStateOf(selectDateTo.value?.year ?: LocalDate.now().year)
    }

    LaunchedEffect(scaffoldState.bottomSheetState.targetValue) {
        selectDateFrom.value = dateFlight.first
        selectDateTo.value = dateFlight.second
        selectorState = 0
    }

    LaunchedEffect(selectDateFrom.value) {
        if (selectDateFrom.value == null) {
            selectorState = 0
            selectDateTo.value = null
        }
    }

    Box(
        modifier = modifier
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
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                SelectorDate(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            color = Color.White
                        )
                        .border(
                            width = 2.dp,
                            color = if (selectorState == 0) MainBlue
                            else Color.Transparent,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            selectorState = 0
                        }
                        .padding(
                            12.dp
                        ),
                    hintText = "Туда",
                    selected = selectorState == 0,
                    dateState = selectDateFrom
                )

                Spacer(
                    modifier = Modifier
                        .width(20.dp)
                )

                SelectorDate(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            color = Color.White
                        )
                        .border(
                            width = 2.dp,
                            color = if (selectorState == 1) MainBlue
                            else Color.Transparent,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            if (selectDateFrom.value != null)
                                selectorState = 1
                        }
                        .padding(
                            12.dp
                        ),
                    hintText = "Обратно",
                    selected = selectorState == 1,
                    dateState = selectDateTo
                )
            }

            AnimatedContent(
                targetState = selectorState,
                transitionSpec = {
                    fadeIn(
                        animationSpec = tween(
                            durationMillis = 100,
                            easing = FastOutLinearInEasing
                        )
                    ) togetherWith fadeOut(
                        animationSpec = tween(
                            durationMillis = 100,
                            easing = FastOutLinearInEasing
                        )
                    )
                },
                label = "calendar",
            ) { selector ->

                if (selector == 0)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(308.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier
                                .padding(
                                    top = 16.dp,
                                    bottom = 12.dp
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "${monthTextFrom.value}, ${yearTextFrom.intValue}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = BlackText
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 30.dp
                                ),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС").forEach {
                                Box(
                                    modifier = Modifier
                                        .width(36.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = it,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = BlackText
                                    )
                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .padding(
                                    top = 6.dp
                                )
                        ) {

                            Calendar(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        bottom = 12.dp
                                    ),
                                selectedDate = selectDateFrom,
                                inBound = { value ->
                                    if (selectDateTo.value != null) value <= selectDateTo.value else true
                                },
                                months = months,
                                monthValue = monthValueFrom,
                                pagerMonthStateSaved = pagerMonthStateSavedFrom,
                                monthText = monthTextFrom,
                                yearText = yearTextFrom
                            )
                        }
                    }
                else
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(308.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier
                                .padding(
                                    top = 16.dp,
                                    bottom = 12.dp
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "${monthTextTo.value}, ${yearTextTo.intValue}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = BlackText
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 30.dp
                                ),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС").forEach {
                                Box(
                                    modifier = Modifier
                                        .width(36.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = it,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = BlackText
                                    )
                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .padding(
                                    top = 6.dp
                                )
                        ) {

                            Calendar(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        bottom = 12.dp
                                    ),
                                selectedDate = selectDateTo,
                                inBound = { value ->
                                    value >= selectDateFrom.value
                                },
                                months = months,
                                monthValue = monthValueTo,
                                pagerMonthStateSaved = pagerMonthStateSavedTo,
                                monthText = monthTextTo,
                                yearText = yearTextTo
                            )
                        }
                    }
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            ConfirmButton(
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(
                        color = CustomGreen
                    )
                    .clickable {
                        scope.launch {
                            onConfirmClick(
                                selectDateFrom.value,
                                selectDateTo.value
                            )

                            scaffoldState.bottomSheetState.hide()
                        }
                    }
                    .padding(
                        vertical = 16.dp
                    ),
                text = "Готово"
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewCalendarContent() {
    CalendarContent(
        modifier = Modifier
            .fillMaxWidth()
    )
}

private fun getWeeksFromStartDate(
    startDate: LocalDate,
    weeksCount: Int
): List<List<LocalDate>> {
    val weeks = mutableListOf<List<LocalDate>>()
    var currentStartOfWeek = startDate

    while (currentStartOfWeek.dayOfWeek != DayOfWeek.MONDAY) {
        currentStartOfWeek = currentStartOfWeek.minusDays(1)
    }

    repeat(weeksCount) {
        val week = (0 until 7).map { currentStartOfWeek.plusDays(it.toLong()) }
        weeks.add(week)
        currentStartOfWeek = currentStartOfWeek.plusWeeks(1)
    }

    return weeks
}

private fun getCurrentMonth(months: List<List<LocalDate>>, currentDate: LocalDate): Int {
    for (i in months.indices)
        if (months[i][3].month == currentDate.month) return i

    return 0
}

private fun getMonthsFromWeeks(weeks: List<List<LocalDate>>): List<List<LocalDate>> {
    var currentMonth = Month.JANUARY
    var arrayDaysOfMonth = ArrayList<LocalDate>()
    val arrayOfMonths = ArrayList<List<LocalDate>>()

    for (i in weeks.indices) {

        for (j in weeks[i].indices) {

            if (weeks[i][j].month == currentMonth)
                arrayDaysOfMonth.add(weeks[i][j])
            else {
                if (arrayDaysOfMonth.size in 28..31) {

                    arrayOfMonths.add(arrayDaysOfMonth)

                    arrayDaysOfMonth = ArrayList()

                    currentMonth = currentMonth.plus(1)

                    arrayDaysOfMonth.add(weeks[i][j])
                }
            }
        }
    }

    if (arrayDaysOfMonth.size != 0) {

        var day = arrayDaysOfMonth.last().plusDays(1)

        while (day.month == currentMonth) {

            arrayDaysOfMonth.add(day)
            day = day.plusDays(1)
        }
    }

    arrayOfMonths.add(arrayDaysOfMonth)

    return arrayOfMonths
}