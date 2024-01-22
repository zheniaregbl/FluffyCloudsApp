package ru.syndicate.fluffyclouds.navigation.app_navigation

sealed class ScreenRoute(val route: String) {
    data object SplashScreen: ScreenRoute("splash_screen")
    data object StartScreen: ScreenRoute("start_screen")
    data object AuthScreen: ScreenRoute("auth_screen")
    data object RegisterScreen: ScreenRoute("register_screen")
    data object FlightScreen: ScreenRoute("flight_screen")
    data object TicketScreen: ScreenRoute("ticket_screen")
    data object ProfileScreen: ScreenRoute("profile_screen")
    data object SelectTownFromScreen: ScreenRoute("select_town_from_screen")
    data object SelectTownToScreen: ScreenRoute("select_town_to_screen")
}