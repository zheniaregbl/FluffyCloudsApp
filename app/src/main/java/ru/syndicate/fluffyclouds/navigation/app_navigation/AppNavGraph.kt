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
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.extensions.canGoBack
import ru.syndicate.fluffyclouds.extensions.currentRoute
import ru.syndicate.fluffyclouds.ui.screens.flight_list_screen.FlightListScreen
import ru.syndicate.fluffyclouds.ui.screens.home_screen.HomeScreen
import ru.syndicate.fluffyclouds.ui.screens.info_flight_screen.InfoFlightScreen
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
    appNavController: NavHostController,
    scaffoldState: BottomSheetScaffoldState,
    appViewModel: AppViewModel,
    searchTown: Pair<TownFlightModel, TownFlightModel>,
    dateFlight: Pair<LocalDate?, LocalDate?>,
    peopleClassState: PeopleClassState
) {

    NavHost(
        navController = appNavController,
        startDestination = ScreenRoute.SplashScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {

        composable(
            route = ScreenRoute.SplashScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            SplashScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White
                    ),
                navigateToNext = {
                    appNavController.navigate(ScreenRoute.FlightScreen.route) {
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
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            StartScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White
                    ),
                navigateToRegister = {
                    appNavController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(ScreenRoute.StartScreen.route)
                    }
                },
                navigateToAuth = {
                    appNavController.navigate(ScreenRoute.AuthScreen.route) {
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
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            RegisterScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White
                    ),
                isRegister = false,
                navigateToRegister = {
                    appNavController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(ScreenRoute.AuthScreen.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToAuth = {
                    appNavController.navigate(ScreenRoute.AuthScreen.route) {
                        popUpTo(ScreenRoute.RegisterScreen.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToHome = {
                    appNavController.navigate(ScreenRoute.FlightScreen.route) {
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
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            RegisterScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White
                    ),
                isRegister = true,
                navigateToRegister = {
                    appNavController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(ScreenRoute.AuthScreen.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToAuth = {
                    appNavController.navigate(ScreenRoute.AuthScreen.route) {
                        popUpTo(ScreenRoute.RegisterScreen.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToHome = {
                    appNavController.navigate(ScreenRoute.FlightScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        navigation(
            startDestination = FlightScreenRoute.HomeScreen.route,
            route = ScreenRoute.FlightScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            composable(
                route = FlightScreenRoute.HomeScreen.route,
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            durationMillis = 200,
                            easing = Ease
                        )
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            durationMillis = 200,
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
                    changeSheetContent = {
                        if (scaffoldState.bottomSheetState.targetValue != SheetValue.Expanded)
                            appViewModel.onEvent(AppEvent.ChangeSheetContentType(it))
                    },
                    onClickFromField = {
                        if (appNavController.currentRoute != ScreenRoute.SelectTownFromScreen.route)
                            appNavController.navigate(ScreenRoute.SelectTownFromScreen.route)
                    },
                    onClickToField = {
                        if (appNavController.currentRoute != ScreenRoute.SelectTownToScreen.route)
                            appNavController.navigate(ScreenRoute.SelectTownToScreen.route)
                    },
                    onClickSwap = {
                        appViewModel.onEvent(AppEvent.SwapTown)
                    },
                    searchFlight = {
                        if (appNavController.currentRoute != FlightScreenRoute.FlightListScreen.route)
                            appNavController.navigate(FlightScreenRoute.FlightListScreen.route)
                    }
                )
            }

            composable(
                route = FlightScreenRoute.FlightListScreen.route,
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            durationMillis = 200,
                            easing = Ease
                        )
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            durationMillis = 200,
                            easing = Ease
                        )
                    )
                }
            ) {

                FlightListScreen(
                    modifier = Modifier
                        .fillMaxSize(),
                    scaffoldState = scaffoldState,
                    flightPair = searchTown,
                    dateFlight = dateFlight,
                    peopleClassState = peopleClassState,
                    changeSheetContent = {
                        if (scaffoldState.bottomSheetState.targetValue != SheetValue.Expanded)
                            appViewModel.onEvent(AppEvent.ChangeSheetContentType(it))
                    },
                    navigateToInfoFlight = {
                        if (appNavController.currentRoute != ScreenRoute.InfoFlightScreen.route)
                            appNavController.navigate(ScreenRoute.InfoFlightScreen.route)
                    },
                    navigateToInfoFlightTransfer = {
                        if (appNavController.currentRoute != "transfers")
                            appNavController.navigate("transfers")
                    },
                    clickToBack = {
                        if (appNavController.canGoBack)
                            appNavController.popBackStack()
                    }
                )
            }
        }

        composable(
            route = ScreenRoute.TicketScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
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
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
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
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            SelectTownScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 20.dp
                    ),
                onClickTown = { town ->
                    appViewModel.onEvent(AppEvent.ChangeTownFrom(town))
                    appNavController.navigate(ScreenRoute.FlightScreen.route) {
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
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            SelectTownScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 20.dp
                    ),
                onClickTown = { town ->
                    appViewModel.onEvent(AppEvent.ChangeTownTo(town))
                    appNavController.navigate(ScreenRoute.FlightScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.InfoFlightScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            InfoFlightScreen(
                modifier = Modifier
                    .fillMaxSize(),
                clickToBack = {
                    if (appNavController.canGoBack && appNavController.currentRoute != FlightScreenRoute.FlightListScreen.route)
                        appNavController.popBackStack()
                }
            )
        }

        composable(
            route = "transfers",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            InfoFlightScreen(
                modifier = Modifier
                    .fillMaxSize(),
                clickToBack = {
                    if (appNavController.canGoBack && appNavController.currentRoute != FlightScreenRoute.FlightListScreen.route)
                        appNavController.popBackStack()
                },
                transfers = 2
            )
        }
    }
}