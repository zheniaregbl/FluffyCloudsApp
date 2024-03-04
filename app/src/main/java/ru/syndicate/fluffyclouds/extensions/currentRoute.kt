package ru.syndicate.fluffyclouds.extensions

import androidx.navigation.NavHostController

val NavHostController.currentRoute: String?
    get() = this.currentBackStackEntry?.destination?.route