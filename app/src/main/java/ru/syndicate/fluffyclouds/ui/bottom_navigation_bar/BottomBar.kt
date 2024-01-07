package ru.syndicate.fluffyclouds.ui.bottom_navigation_bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.data.model.BottomBarTab
import ru.syndicate.fluffyclouds.ui.theme.BackgroundBottomBar
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {

    val tabs = listOf(
        BottomBarTab.Home,
        BottomBarTab.Tickets,
        BottomBarTab.Profile
    )

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        BottomBarTabs(
            tabs = tabs,
            selectedTab = selectedTabIndex,
            onTabSelected = { tab ->
                selectedTabIndex = tabs.indexOf(tab)
            }
        )
    }
}

@Composable
fun BottomBarTabs(
    tabs: List<BottomBarTab>,
    selectedTab: Int,
    onTabSelected: (BottomBarTab) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        for (tab in tabs) {

            val weight by animateFloatAsState(
                targetValue = if (selectedTab == tabs.indexOf(tab)) 1f else 0.5f,
                label = "weight"
            )
            val alpha by animateFloatAsState(
                targetValue = if (selectedTab == tabs.indexOf(tab)) 1f else 0.8f,
                label = "alpha"
            )
            val color by animateColorAsState(
                targetValue = if (selectedTab == tabs.indexOf(tab)) Color.White else BackgroundBottomBar,
                label = "color"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(weight)
                    .clip(RoundedCornerShape(30.dp))
                    .background(
                        color = color
                    )
                    .pointerInput(Unit) {
                        detectTapGestures {
                            onTabSelected(tab)
                        }
                    }
                    .padding(
                        horizontal = 6.dp,
                        vertical = 2.dp
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier
                        .size(28.dp)
                        .alpha(alpha),
                    imageVector = ImageVector.vectorResource(id = tab.icon),
                    contentDescription = null,
                    tint = MainBlue
                )

                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )

                AnimatedVisibility(
                    visible = tabs[selectedTab] == tab,
                    enter = fadeIn(
                        animationSpec = tween(
                            durationMillis = 150,
                            easing = EaseIn
                        )
                    ),
                    exit = fadeOut(
                        animationSpec = tween(
                            durationMillis = 10,
                            easing = LinearEasing
                        )
                    )
                ) {

                    Text(
                        text = tab.title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = MainBlue
                    )
                }
            }
        }
    }
}