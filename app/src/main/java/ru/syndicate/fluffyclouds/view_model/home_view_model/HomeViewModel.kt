package ru.syndicate.fluffyclouds.view_model.home_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.syndicate.fluffyclouds.data.model.Airplane
import ru.syndicate.fluffyclouds.data.repository.CloudsRepositoryImpl
import ru.syndicate.fluffyclouds.info_functions.getAirplanesFromJson
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CloudsRepositoryImpl
): ViewModel() {

    private val _airplaneList = MutableLiveData<List<Airplane>>()
    val airplaneList: LiveData<List<Airplane>> = _airplaneList

    init {
        filterAirplane("")
    }

    fun onEvent(event: HomeEvent) {
        when (event) {

            is HomeEvent.FilterAirplane -> {
                filterAirplane(event.model)
            }

            is HomeEvent.SearchAirplane -> {
                searchAirplane(event.model)
            }
        }
    }

    private fun filterAirplane(model: String) {
        viewModelScope.launch {
            _airplaneList.postValue(
                getAirplanesFromJson(repository.getAirplaneWithFilter(model))
            )
        }
    }

    private fun searchAirplane(model: String) {
        viewModelScope.launch {
            _airplaneList.postValue(
                getAirplanesFromJson(repository.searchAirplaneByModel(model))
            )
        }
    }
}