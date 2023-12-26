package ru.syndicate.fluffyclouds.data.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import ru.syndicate.fluffyclouds.data.model.RegistrationToken
import ru.syndicate.fluffyclouds.data.remote.CloudsApi
import ru.syndicate.fluffyclouds.domain.repository.CloudsRepository
import javax.inject.Inject

class CloudsRepositoryImpl @Inject constructor(
    private val cloudsApi: CloudsApi
): CloudsRepository {

    override suspend fun registration(
        email: String,
        password: String
    ): RegistrationToken = withContext(Dispatchers.Main) {
        val response = cloudsApi.registration(email, password)

        if (response.isSuccessful) {
            val jsonObject = JSONObject(response.body().toString())

            Log.d("checkRegisterToken", jsonObject.getString("token"))

            RegistrationToken(
                success = true,
                token = jsonObject.getString("token")
            )

        } else {
            val error = response.errorBody()?.string().toString()

            Log.d("checkRegisterToken", error)

            RegistrationToken(
                error = error
            )
        }
    }

    override suspend fun login(
        email: String,
        password: String
    ): RegistrationToken = withContext(Dispatchers.Main) {
        val response = cloudsApi.login(email, password)

        if (response.isSuccessful) {
            val jsonObject = JSONObject(response.body().toString())

            Log.d("checkRegisterToken", jsonObject.getString("token"))

            RegistrationToken(
                success = true,
                token = jsonObject.getString("token")
            )

        } else {
            val error = response.errorBody()?.string().toString()

            Log.d("checkRegisterToken", error)

            RegistrationToken(
                error = error
            )
        }
    }

    override suspend fun getAirplaneWithFilter(model: String): JSONArray = withContext(Dispatchers.IO) {
        val response = cloudsApi.getAirplaneWithFilter(model)

        if (response.isSuccessful) JSONArray(response.body().toString()) else JSONArray()
    }

    override suspend fun searchAirplaneByModel(model: String): JSONArray = withContext(Dispatchers.IO) {
        val response = cloudsApi.searchAirplaneByModel(model)

        if (response.isSuccessful) JSONArray(response.body().toString()) else JSONArray()
    }
}