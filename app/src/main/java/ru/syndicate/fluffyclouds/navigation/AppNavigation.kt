package ru.syndicate.fluffyclouds.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.syndicate.fluffyclouds.navigation.utils.getCurrentRoute

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
) {

    val routeList = listOf(
        ScreenRoute.HomeScreen.route
    )

    val currentRoute = getCurrentRoute(navController = navController)

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        contentWindowInsets = WindowInsets.systemBars
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