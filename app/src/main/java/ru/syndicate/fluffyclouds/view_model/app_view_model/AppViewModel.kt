package ru.syndicate.fluffyclouds.view_model.app_view_model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.syndicate.fluffyclouds.data.repository.CloudsRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: CloudsRepositoryImpl
): ViewModel() {

}