package ru.syndicate.fluffyclouds.view_model.home_view_model

sealed interface HomeEvent {

    data class FilterAirplane(
        val model: String
    ): HomeEvent

    data class SearchAirplane(
        val model: String
    ): HomeEvent
}