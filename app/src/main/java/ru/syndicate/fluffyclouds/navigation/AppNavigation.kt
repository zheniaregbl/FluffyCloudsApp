package ru.syndicate.fluffyclouds.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.syndicate.fluffyclouds.navigation.utils.getCurrentRoute
import ru.syndicate.fluffyclouds.ui.bottom_navigation_bar.BottomBar
import ru.syndicate.fluffyclouds.ui.theme.BackgroundBottomBar

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
) {

    val routeList = listOf(
        ScreenRoute.HomeScreen.route
    )

    val currentRoute = getCurrentRoute(navController = navController)

    val showNavigationMenu = navController
        .currentBackStackEntryAsState().value?.destination?.route in routeList.map { it }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        contentWindowInsets = WindowInsets.systemBars,
        bottomBar = {

            if (showNavigationMenu)
                BottomBar(
                    modifier = Modifier
                        .padding(
                            vertical = 50.dp,
                            horizontal = 50.dp
                        )
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(CircleShape)
                        .background(
                            color = BackgroundBottomBar
                        )
                )
        }
    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {

            AppNavGraph(
                navController = navController,
                paddingValues = paddingValues
            )
        }
    }
}