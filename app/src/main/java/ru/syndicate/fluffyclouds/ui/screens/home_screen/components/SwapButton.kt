package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.theme.CircleBlack

@Composable
fun SwapButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { }
) {

    var flagStartPosition by remember {
        mutableStateOf(true)
    }
    val rotate by animateIntAsState(
        targetValue = if (flagStartPosition) 0 else 180,
        animationSpec = tween(
            durationMillis = 180,
            easing = Ease
        ),
        label = "rotate"
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .background(
                    color = CircleBlack
                )
                .graphicsLayer {
                    rotationZ = rotate.toFloat()
                }
                .clickable {
                    flagStartPosition = !flagStartPosition
                    onClick()
                },
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.svg_swap),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}