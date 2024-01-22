package ru.syndicate.fluffyclouds.ui.sheet_content.calendar_content.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import java.time.LocalDate
import java.time.Month

@Composable
fun SelectorDate(
    modifier: Modifier = Modifier,
    hintText: String = "Туда",
    selected: Boolean = false,
    dateState: MutableState<LocalDate?> = mutableStateOf(LocalDate.now())
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = if (dateState.value == null) hintText else getSelectorText(dateState.value!!),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = if (!selected && dateState.value == null) GrayText else BlackText
        )

        AnimatedVisibility(
            visible = dateState.value != null && selected,
            enter = scaleIn(
                animationSpec = tween(
                    durationMillis = 120
                )
            ),
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = 120
                )
            )
        ) {
            Icon(
                modifier = Modifier
                    .padding(
                        top = 2.dp
                    )
                    .size(16.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) {
                        dateState.value = null
                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.svg_cancel),
                contentDescription = null,
                tint = GrayText
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun PreviewSelectorDate() {
    SelectorDate(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = Color.White
            )
            .border(
                width = 1.5.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(
                12.dp
            ),
        dateState = mutableStateOf(LocalDate.now())
    )
}

private fun getSelectorText(date: LocalDate) = "${date.dayOfMonth} ${getTextMonth(date.month)}"

private fun getTextMonth(month: Month) = when (month) {
    Month.JANUARY -> "январь"
    Month.FEBRUARY -> "февраль"
    Month.MARCH -> "март"
    Month.APRIL -> "апрель"
    Month.MAY -> "май"
    Month.JUNE -> "июнь"
    Month.JULY -> "июль"
    Month.AUGUST -> "август"
    Month.SEPTEMBER -> "сентябрь"
    Month.OCTOBER -> "октябрь"
    Month.NOVEMBER -> "ноябрь"
    Month.DECEMBER -> "декабрь"
    else -> "январь"
}