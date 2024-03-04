package ru.syndicate.fluffyclouds.ui.common

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun CustomSwitch(
    switchPadding: Dp,
    buttonWidth: Dp,
    buttonHeight: Dp,
    value: Boolean,
    onSwitch: () -> Unit,
) {

    val switchSize by remember {
        mutableStateOf(buttonHeight - switchPadding * 2)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    var padding by remember {
        mutableStateOf(0.dp)
    }

    padding = if (value) buttonWidth - switchSize - switchPadding * 2 else 0.dp

    val animateSize by animateDpAsState(
        targetValue = if (value) padding else 0.dp,
        animationSpec = tween(
            durationMillis = 200,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        ),
        label = ""
    )

    Box(
        modifier = Modifier
            .width(buttonWidth)
            .height(buttonHeight)
            .clip(CircleShape)
            .background(if (value) MainBlue else GrayText)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onSwitch()
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(switchPadding)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(animateSize)
                    .background(Color.Transparent)
            )

            Box(
                modifier = Modifier
                    .size(switchSize)
                    .clip(CircleShape)
                    .background(Color.White)
            )
        }
    }
}