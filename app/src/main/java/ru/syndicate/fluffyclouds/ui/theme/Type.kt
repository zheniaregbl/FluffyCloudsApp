package ru.syndicate.fluffyclouds.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ru.syndicate.fluffyclouds.R

val fontFamily = FontFamily(
    Font(R.font.sfprotext_regular, FontWeight.Normal),
    Font(R.font.sfprotext_medium, FontWeight.Medium),
    Font(R.font.sfprotext_semibold, FontWeight.SemiBold),
    Font(R.font.sfprotext_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = fontFamily,
    )
)