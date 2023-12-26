package ru.syndicate.fluffyclouds.data.remote

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CloudsApi {

    @POST("register")
    suspend fun registration(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<JsonObject>

    @POST("login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<JsonObject>

    @GET("airplane")
    suspend fun getAirplaneWithFilter(
        @Query("model") model: String
    ): Response<JsonArray>

    @GET("searchAirplane")
    suspend fun searchAirplaneByModel(
        @Query("model") model: String
    ): Response<JsonArray>
}