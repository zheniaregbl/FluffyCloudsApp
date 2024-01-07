package ru.syndicate.fluffyclouds.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.syndicate.fluffyclouds.ui.screens.home_screen.HomeScreen
import ru.syndicate.fluffyclouds.ui.screens.register_screen.RegisterScreen
import ru.syndicate.fluffyclouds.ui.screens.splash_screen.SplashScreen
import ru.syndicate.fluffyclouds.ui.screens.start_screen.StartScreen
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor

@Composable
fun AppNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
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
                    navController.navigate(ScreenRoute.HomeScreen.route) {
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
                    navController.navigate(ScreenRoute.HomeScreen.route) {
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
                    navController.navigate(ScreenRoute.HomeScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.HomeScreen.route,
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
                    .fillMaxSize()
                    .background(
                        color = BackgroundColor
                    )
            )
        }
    }
}