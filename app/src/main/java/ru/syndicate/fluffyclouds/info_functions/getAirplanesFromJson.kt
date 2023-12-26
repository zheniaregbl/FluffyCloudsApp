package ru.syndicate.fluffyclouds.info_functions

import org.json.JSONArray
import ru.syndicate.fluffyclouds.data.model.Airplane

fun getAirplanesFromJson(
    jsonArray: JSONArray
): List<Airplane> {

    val airplaneList = ArrayList<Airplane>()

    for (i in 0..<jsonArray.length()) {
        val airplane = jsonArray.getJSONObject(i)

        airplaneList.add(
            Airplane(
                id = airplane.getInt("airplaneId"),
                model = airplane.getString("model"),
                quantitySeat = airplane.getInt("amout_seat")
            )
        )
    }

    return airplaneList
}