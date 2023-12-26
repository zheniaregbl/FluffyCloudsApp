package ru.syndicate.fluffyclouds.domain.repository

import com.google.gson.JsonObject
import org.json.JSONArray
import ru.syndicate.fluffyclouds.data.model.RegistrationToken

interface CloudsRepository {
    suspend fun registration(email: String, password: String): RegistrationToken
    suspend fun login(email: String, password: String): RegistrationToken
    suspend fun getAirplaneWithFilter(model: String): JSONArray
    suspend fun searchAirplaneByModel(model: String): JSONArray
}