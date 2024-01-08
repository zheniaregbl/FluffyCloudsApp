package ru.syndicate.fluffyclouds.ui.sheet_content.people_class_content.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier,
    categoryText: String = "Взрослые",
    categoryDescription: String = "12 лет и старше",
    minValue: Int = 1,
    maxValue: Int = 5,
    state: MutableState<Int> = mutableIntStateOf(1)
) {

    val backgroundMinus by animateColorAsState(
        targetValue = if (state.value > minValue) MainBlue else BackgroundColor,
        label = "backgroundMinusColor"
    )
    val minusIconColor by animateColorAsState(
        targetValue = if (state.value > minValue) Color.White else GrayText,
        label = "minusColor"
    )

    val backgroundPlus by animateColorAsState(
        targetValue = if (state.value == maxValue) BackgroundColor else MainBlue,
        label = "backgroundPlusColor"
    )
    val plusIconColor by animateColorAsState(
        targetValue = if (state.value == maxValue) GrayText else Color.White,
        label = "plusColor"
    )

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {

            Text(
                text = categoryText,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = BlackText
            )

            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )

            Text(
                text = categoryDescription,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = GrayText
            )
        }

        Row(
            modifier = Modifier
                .width(110.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(
                        color = backgroundMinus
                    )
                    .clickable {
                        if (state.value != minValue) state.value -= 1
                    },
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_minus),
                    contentDescription = null,
                    tint = minusIconColor
                )
            }

            Text(
                text = state.value.toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = BlackText
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(
                        color = backgroundPlus
                    )
                    .clickable {
                        if (state.value != maxValue) state.value += 1
                    },
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_plus),
                    contentDescription = null,
                    tint = plusIconColor
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCategoryRow() {
    CategoryRow(
        modifier = Modifier
            .fillMaxWidth()
    )
}