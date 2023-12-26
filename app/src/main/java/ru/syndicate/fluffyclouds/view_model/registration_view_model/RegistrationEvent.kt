package ru.syndicate.fluffyclouds.view_model.registration_view_model

import android.content.Context

sealed interface RegistrationEvent {

    data class Registration(
        val email: String,
        val password: String,
        val context: Context
    ): RegistrationEvent

    data class Authorization(
        val email: String,
        val password: String,
        val context: Context
    ): RegistrationEvent
}