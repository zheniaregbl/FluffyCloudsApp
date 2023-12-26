package ru.syndicate.fluffyclouds.view_model.registration_view_model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.fluffyclouds.data.model.RegistrationState
import ru.syndicate.fluffyclouds.data.repository.CloudsRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: CloudsRepositoryImpl
): ViewModel() {

    val state = MutableStateFlow(RegistrationState())

    fun onEvent(event: RegistrationEvent) {
        when (event) {

            is RegistrationEvent.Authorization -> authorization(
                event.email,
                event.password,
                event.context
            )

            is RegistrationEvent.Registration -> registration(
                event.email,
                event.password,
                event.context
            )
        }
    }

    private fun registration(
        email: String,
        password: String,
        context: Context
    ) {
        viewModelScope.launch(Dispatchers.Main) {
            val registrationToken = repository.registration(email, password)

            if (registrationToken.success) {
                state.update { it.copy(
                    enter = true
                ) }
            } else {
                Log.d("checkRegisterToken", registrationToken.error)
                Toast.makeText(context, registrationToken.error, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun authorization(
        email: String,
        password: String,
        context: Context
    ) {
        viewModelScope.launch(Dispatchers.Main) {
            val authorizationToken = repository.login(email, password)

            if (authorizationToken.success) {

                state.update { it.copy(
                    enter = true
                ) }
            } else {
                Log.d("checkRegisterToken", authorizationToken.error)
                Toast.makeText(context, authorizationToken.error, Toast.LENGTH_LONG).show()
            }
        }
    }
}