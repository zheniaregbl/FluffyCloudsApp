package ru.syndicate.fluffyclouds.navigation.app_navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.navigation.flight_navigation.FlightNavigation
import ru.syndicate.fluffyclouds.ui.screens.profile_screen.ProfileScreen
import ru.syndicate.fluffyclouds.ui.screens.register_screen.RegisterScreen
import ru.syndicate.fluffyclouds.ui.screens.select_town_screen.SelectTownScreen
import ru.syndicate.fluffyclouds.ui.screens.splash_screen.SplashScreen
import ru.syndicate.fluffyclouds.ui.screens.start_screen.StartScreen
import ru.syndicate.fluffyclouds.ui.screens.ticket_screen.TicketScreen
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.view_model.app_view_model.AppEvent
import ru.syndicate.fluffyclouds.view_model.app_view_model.AppViewModel
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(
    navController: NavHostController,
    scaffoldState: BottomSheetScaffoldState,
    appViewModel: AppViewModel,
    searchTown: Pair<TownFlightModel, TownFlightModel>,
    dateFlight: Pair<LocalDate?, LocalDate?>,
    sheetState: SheetContentState,
    peopleClassState: PeopleClassState
) {

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.SplashScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {

        composable(
            route = ScreenRoute.SplashScreen.route,
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

            SplashScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToNext = {
                    navController.navigate(ScreenRoute.FlightScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.StartScreen.route,
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

            StartScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToRegister = {
                    navController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(ScreenRoute.StartScreen.route)
                    }
                },
                navigateToAuth = {
                    navController.navigate(ScreenRoute.AuthScreen.route) {
                        popUpTo(ScreenRoute.StartScreen.route)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.AuthScreen.route,
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

            RegisterScreen(
                modifier = Modifier
                    .fillMaxSize(),
                isRegister = false,
                navigateToRegister = {
                    navController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(ScreenRoute.AuthScreen.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToAuth = {
                    navController.navigate(ScreenRoute.AuthScreen.route) {
                        popUpTo(ScreenRoute.RegisterScreen.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToHome = {
                    navController.navigate(ScreenRoute.FlightScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.RegisterScreen.route,
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

            RegisterScreen(
                modifier = Modifier
                    .fillMaxSize(),
                isRegister = true,
                navigateToRegister = {
                    navController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(ScreenRoute.AuthScreen.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToAuth = {
                    navController.navigate(ScreenRoute.AuthScreen.route) {
                        popUpTo(ScreenRoute.RegisterScreen.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToHome = {
                    navController.navigate(ScreenRoute.FlightScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.FlightScreen.route,
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

            FlightNavigation(
                globalNavController = navController,
                scaffoldState = scaffoldState,
                appViewModel = appViewModel,
                searchTown = searchTown,
                dateFlight = dateFlight,
                peopleClassState = peopleClassState,
                sheetState = sheetState
            )
        }

        composable(
            route = ScreenRoute.TicketScreen.route,
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

            TicketScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(
            route = ScreenRoute.ProfileScreen.route,
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

            ProfileScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(
            route = ScreenRoute.SelectTownFromScreen.route,
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

            SelectTownScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = BackgroundColor
                    )
                    .padding(
                        horizontal = 20.dp,
                        vertical = 20.dp
                    ),
                onClickTown = { town ->
                    appViewModel.onEvent(AppEvent.ChangeTownFrom(town))
                    navController.navigate(ScreenRoute.FlightScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.SelectTownToScreen.route,
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

            SelectTownScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = BackgroundColor
                    )
                    .padding(
                        horizontal = 20.dp,
                        vertical = 20.dp
                    ),
                onClickTown = { town ->
                    appViewModel.onEvent(AppEvent.ChangeTownTo(town))
                    navController.navigate(ScreenRoute.FlightScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}