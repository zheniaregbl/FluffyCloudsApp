package ru.syndicate.fluffyclouds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.syndicate.fluffyclouds.navigation.AppNavigation
import ru.syndicate.fluffyclouds.ui.theme.FluffyCloudsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            FluffyCloudsTheme {

                AppNavigation()
            }
        }
    }
}