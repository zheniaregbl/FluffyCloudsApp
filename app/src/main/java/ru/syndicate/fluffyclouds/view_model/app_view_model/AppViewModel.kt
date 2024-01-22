package ru.syndicate.fluffyclouds.view_model.app_view_model

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    sharedPreferences: SharedPreferences
): ViewModel() {

    val searchTowns = MutableStateFlow(
        Pair(
            TownFlightModel(
                town = ""
            ),
            TownFlightModel(
                town = ""
            )
        )
    )
    val dateFlight: MutableStateFlow<Pair<LocalDate?, LocalDate?>> =
        MutableStateFlow(
            Pair(null, null)
        )
    val peopleClassState = MutableStateFlow(PeopleClassState())
    val sheetContentState = MutableStateFlow(SheetContentState.CALENDAR)

    fun onEvent(event: AppEvent) {

        when (event) {

            is AppEvent.ChangeTownFrom -> {
                searchTowns.update { it.copy(
                    first = event.fromTown
                ) }
            }

            is AppEvent.ChangeTownTo -> {
                searchTowns.update { it.copy(
                    second = event.toTown
                ) }
            }

            AppEvent.SwapTown -> {
                val prevState = searchTowns.value

                searchTowns.update { it.copy(
                    first = prevState.second,
                    second = prevState.first
                ) }
            }

            is AppEvent.ChangeFlightDate -> {
                dateFlight.update { it.copy(
                    first = event.dateFrom,
                    second = event.dateTo
                ) }
            }

            is AppEvent.ChangePeopleClass -> {
                peopleClassState.update { it.copy(
                    adultCount = event.adult,
                    childrenCount = event.children,
                    infantCount = event.infant,
                    classState = event.indexClass
                ) }
            }

            is AppEvent.ChangeSheetContentType -> {
                sheetContentState.update { event.type }
            }
        }
    }
}