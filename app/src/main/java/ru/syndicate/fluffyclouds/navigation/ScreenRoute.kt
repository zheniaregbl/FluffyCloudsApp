package ru.syndicate.fluffyclouds.navigation

sealed class ScreenRoute(val route: String) {
    data object SplashScreen: ScreenRoute("splash_screen")
    data object StartScreen: ScreenRoute("start_screen")
    data object AuthScreen: ScreenRoute("auth_screen")
    data object RegisterScreen: ScreenRoute("register_screen")
    data object HomeScreen: ScreenRoute("home_screen")
}