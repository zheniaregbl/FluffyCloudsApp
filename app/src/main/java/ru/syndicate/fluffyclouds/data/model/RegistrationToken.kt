package ru.syndicate.fluffyclouds.data.model

data class RegistrationToken(
    val success: Boolean = false,
    val token: String = "",
    val error: String = ""
)
