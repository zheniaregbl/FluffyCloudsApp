package ru.syndicate.fluffyclouds.navigation.flight_navigation

sealed class FlightScreenRoute(val route: String) {
    data object HomeScreen: FlightScreenRoute("home_screen")
    data object FlightListScreen: FlightScreenRoute("flight_list_screen")
}