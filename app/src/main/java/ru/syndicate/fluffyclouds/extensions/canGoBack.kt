package ru.syndicate.fluffyclouds.extensions

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED