package ru.syndicate.fluffyclouds.view_model.sheet_view_model

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import javax.inject.Inject

@HiltViewModel
class SheetViewModel @Inject constructor(
    sharedPreferences: SharedPreferences
): ViewModel() {

    val peopleClassState = MutableStateFlow(PeopleClassState())
    val sheetContentState = MutableStateFlow(SheetContentState.CALENDAR)

    fun onEvent(event: SheetEvent) {

        when(event) {

            is SheetEvent.ChangePeopleClass -> {
                peopleClassState.update { it.copy(
                    adultCount = event.adult,
                    childrenCount = event.children,
                    infantCount = event.infant,
                    classState = event.indexClass
                ) }

                Log.d("changeState", "ok ${event.adult} ${event.children} ${event.infant} ${event.indexClass}")
            }

            is SheetEvent.ChangeSheetContentType -> {
                sheetContentState.update { event.type }
            }
        }
    }
}