package ru.syndicate.fluffyclouds.view_model.app_view_model

import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import java.time.LocalDate

sealed interface AppEvent {

    data class ChangeTownFrom(
        val fromTown: TownFlightModel
    ): AppEvent

    data class ChangeTownTo(
        val toTown: TownFlightModel
    ): AppEvent

    data object SwapTown: AppEvent

    data class ChangeFlightDate(
        val dateFrom: LocalDate?,
        val dateTo: LocalDate?,
    ): AppEvent

    data class ChangePeopleClass(
        val adult: Int,
        val children: Int,
        val infant: Int,
        val indexClass: Int
    ): AppEvent

    data class ChangeSheetContentType(
        val type: SheetContentState
    ): AppEvent
}