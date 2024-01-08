package ru.syndicate.fluffyclouds.view_model.sheet_view_model

import ru.syndicate.fluffyclouds.data.model.SheetContentState

sealed interface SheetEvent {

    data class ChangePeopleClass(
        val adult: Int,
        val children: Int,
        val infant: Int,
        val indexClass: Int
    ): SheetEvent

    data class ChangeSheetContentType(
        val type: SheetContentState
    ): SheetEvent
}