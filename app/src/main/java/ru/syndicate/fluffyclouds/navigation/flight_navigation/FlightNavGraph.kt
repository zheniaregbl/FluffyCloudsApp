package ru.syndicate.fluffyclouds.navigation.flight_navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.ui.screens.flight_list_screen.FlightListScreen
import ru.syndicate.fluffyclouds.ui.screens.home_screen.HomeScreen
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightNavGraph(
    navController: NavHostController,
    scaffoldState: BottomSheetScaffoldState,
    searchTown: Pair<TownFlightModel, TownFlightModel>,
    dateFlight: Pair<LocalDate?, LocalDate?>,
    peopleClassState: PeopleClassState,
    changeSheetContent: (SheetContentState) -> Unit,
    selectFromTown: () -> Unit,
    selectToTown: () -> Unit,
    swapTown: () -> Unit,
    searchFlight: () -> Unit
) {

    NavHost(
        navController = navController,
        startDestination = FlightScreenRoute.HomeScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {

        composable(
            route = FlightScreenRoute.HomeScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = Ease
                    )
                )
            }
        ) {

            HomeScreen(
                modifier = Modifier
                    .fillMaxSize(),
                scaffoldState = scaffoldState,
                searchTown = searchTown,
                dateFlight = dateFlight,
                peopleClassState = peopleClassState,
                changeSheetContent = changeSheetContent,
                onClickFromField = selectFromTown,
                onClickToField = selectToTown,
                onClickSwap = swapTown,
                searchFlight = searchFlight
            )
        }

        composable(
            route = FlightScreenRoute.FlightListScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = Ease
                    )
                )
            }
        ) {

            FlightListScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate(FlightScreenRoute.HomeScreen.route) {
                            popUpTo(0)
                        }
                    }
            )
        }
    }
}