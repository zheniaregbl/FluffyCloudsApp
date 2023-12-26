package ru.syndicate.fluffyclouds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ru.syndicate.fluffyclouds.navigation.AppNavigation
import ru.syndicate.fluffyclouds.ui.theme.FluffyCloudsTheme
import ru.syndicate.fluffyclouds.view_model.app_view_model.AppViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            FluffyCloudsTheme {

                AppNavigation()
            }
        }
    }
}