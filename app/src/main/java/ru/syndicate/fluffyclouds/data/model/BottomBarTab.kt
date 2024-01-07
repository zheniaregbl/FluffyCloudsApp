package ru.syndicate.fluffyclouds.data.model

import ru.syndicate.fluffyclouds.R

sealed class BottomBarTab(val title: String, val icon: Int) {
    data object Home: BottomBarTab(
        title = "Главный",
        icon = R.drawable.svg_from
    )
    data object Tickets: BottomBarTab(
        title = "Билеты",
        icon = R.drawable.svg_ticket
    )
    data object Profile: BottomBarTab(
        title = "Профиль",
        icon = R.drawable.svg_profile
    )
}