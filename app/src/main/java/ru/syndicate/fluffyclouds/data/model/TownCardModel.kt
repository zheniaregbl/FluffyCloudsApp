package ru.syndicate.fluffyclouds.data.model

import androidx.compose.runtime.Stable
import ru.syndicate.fluffyclouds.R
import java.util.UUID

@Stable
data class TownCardModel(
    val town: String = "Москва",
    val image: Int = R.drawable.moscow,
    val id: String = UUID.randomUUID().toString()
)
