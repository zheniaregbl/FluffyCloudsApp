package ru.syndicate.fluffyclouds.data.model

import androidx.compose.runtime.Stable

@Stable
data class PeopleClassState(
    val adultCount: Int = 1,
    val childrenCount: Int = 0,
    val infantCount: Int = 0,
    val classState: Int = 0
)
