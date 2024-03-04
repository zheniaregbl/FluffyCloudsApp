package ru.syndicate.fluffyclouds.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import ru.syndicate.fluffyclouds.ui.theme.ShimmerColorShades

@Composable
fun CompanyImage(
    modifier: Modifier,
    url: String,
    imageSize: Dp
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        SubcomposeAsyncImage(
            modifier = Modifier
                .size(imageSize),
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        ) {

            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                ShimmerItem(
                    modifier = Modifier
                        .size(imageSize)
                        .clip(CircleShape)
                )
            } else {
                SubcomposeAsyncImageContent()
            }
        }
    }
}

@Composable
fun ShimmerItem(
    modifier: Modifier = Modifier
) {
    val transition = rememberInfiniteTransition(label = "")
    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 800f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            RepeatMode.Reverse
        ),
        label = ""
    )

    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnimation, translateAnimation)
    )

    Spacer(
        modifier = Modifier
            .composed { modifier }
            .background(
                brush = brush
            )
    )
}