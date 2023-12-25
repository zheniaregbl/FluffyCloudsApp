package ru.syndicate.fluffyclouds.ui.screens.splash_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToNext: () -> Unit = { }
) {

    var showLogo by remember {
        mutableStateOf(false)
    }

    val alpha by animateFloatAsState(
        targetValue = if (showLogo) 1f else 0f,
        animationSpec = tween(1400),
        label = ""
    )

    LaunchedEffect(Unit) {
        showLogo = true
        delay(1500L)
        navigateToNext()
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(alpha),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.svg_logo),
                contentDescription = null,
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    text = "Fluffy",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = BlackText
                )

                Text(
                    text = "Clouds",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MainBlue,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}