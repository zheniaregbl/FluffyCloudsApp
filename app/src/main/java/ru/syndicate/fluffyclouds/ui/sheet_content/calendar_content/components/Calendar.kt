package ru.syndicate.fluffyclouds.ui.sheet_content.calendar_content.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calendar(
    modifier: Modifier = Modifier,
    selectedDate: MutableState<LocalDate?>,
    inBound: (LocalDate) -> Boolean,
    months: List<List<LocalDate>>,
    monthValue: MutableState<Month>,
    pagerMonthStateSaved: MutableState<Int>,
    monthText: MutableState<String>,
    yearText: MutableState<Int>
) {

    val pagerState = rememberPagerState(
        initialPage = pagerMonthStateSaved.value,
        initialPageOffsetFraction = 0f,
        pageCount = { months.size }
    )

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            pagerMonthStateSaved.value = page

            val monthDates = months[page]

            monthText.value = when (monthDates.first().month) {
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

            monthValue.value = monthDates.first().month

            yearText.value = monthDates.first().year
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 30.dp
                ),
            state = pagerState
        ) { page ->
            val monthDates = months[page]
            val weeks = getWeeksFromMonth(monthDates)

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                weeks.forEach { week ->

                    WeekRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        week = week,
                        inBound = inBound,
                        selectedDate = selectedDate,
                    )
                }
            }
        }
    }
}

@Composable
fun WeekRow(
    modifier: Modifier = Modifier,
    week: List<LocalDate>,
    inBound: (LocalDate) -> Boolean,
    selectedDate: MutableState<LocalDate?>
) {
    var currentDayOfWeek = DayOfWeek.MONDAY //DayOfWeek.SUNDAY
    var currentIndex = 0
    var counterDays = 7

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        while (counterDays != 0) {
            if (week[currentIndex].dayOfWeek == currentDayOfWeek) {

                DayItem(
                    inBound = inBound,
                    selectedDate = selectedDate,
                    value = week[currentIndex],
                    isEmpty = false
                )

                if (currentIndex != week.size - 1)
                    currentIndex++

            } else {
                DayItem(
                    inBound = inBound,
                    selectedDate = selectedDate,
                    value = week[currentIndex],
                    isEmpty = true
                )
            }

            counterDays--
            currentDayOfWeek = currentDayOfWeek.plus(1)
        }
    }
}

@Composable
fun DayItem(
    inBound: (LocalDate) -> Boolean,
    selectedDate: MutableState<LocalDate?>,
    value: LocalDate,
    isEmpty: Boolean
) {

    if (!isEmpty)
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .clickable {
                    if (value >= LocalDate.now() && inBound(value))
                        selectedDate.value = value
                }
                .background(
                    color = if (value == selectedDate.value) MainBlue else Color.Transparent
                )
                .border(
                    width = 1.5.dp,
                    color = if (value == selectedDate.value) MainBlue else Color.Transparent,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value.dayOfMonth.toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = when {

                    value < LocalDate.now() -> BlackText.copy(alpha = 0.4f)

                    value == selectedDate.value -> Color.White

                    value != selectedDate.value -> BlackText

                    else -> BlackText
                }
            )
        }
    else
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = BlackText
            )
        }
}

private fun getWeeksFromMonth(month: List<LocalDate>): List<List<LocalDate>> {
    // var currentDayOfWeek = DayOfWeek.SUNDAY
    var currentDayOfWeek = DayOfWeek.MONDAY
    var arrayDaysOfWeek = ArrayList<LocalDate>()
    val arrayWeeksOfMonth = ArrayList<List<LocalDate>>()
    var currentIndex = 0
    var monthSize = month.size

    while (monthSize != 0) {
        if (month[currentIndex].dayOfWeek == currentDayOfWeek) {
            arrayDaysOfWeek.add(month[currentIndex])

            if (currentIndex != month.size - 1)
                currentIndex++
            monthSize--
        }

        if (currentDayOfWeek == DayOfWeek.SUNDAY) {

            arrayWeeksOfMonth.add(arrayDaysOfWeek)
            arrayDaysOfWeek = ArrayList()
        }

        currentDayOfWeek = currentDayOfWeek.plus(1)
    }

    if (arrayDaysOfWeek.isNotEmpty())
        arrayWeeksOfMonth.add(arrayDaysOfWeek)

    return arrayWeeksOfMonth
}