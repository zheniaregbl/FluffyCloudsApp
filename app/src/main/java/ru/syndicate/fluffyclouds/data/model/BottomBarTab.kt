package ru.syndicate.fluffyclouds.data.model

import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.navigation.app_navigation.ScreenRoute

sealed class BottomBarTab(
    val title: String,
    val icon: Int,
    val route: String
) {
    data object Home: BottomBarTab(
        title = "Главный",
        icon = R.drawable.svg_from,
        route = ScreenRoute.FlightScreen.route
    )
    data object Tickets: BottomBarTab(
        title = "Билеты",
        icon = R.drawable.svg_ticket,
        route = ScreenRoute.TicketScreen.route
    )
    data object Profile: BottomBarTab(
        title = "Профиль",
        icon = R.drawable.svg_profile,
        route = ScreenRoute.ProfileScreen.route
    )
}