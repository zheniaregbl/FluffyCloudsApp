package ru.syndicate.fluffyclouds

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ru.syndicate.fluffyclouds.navigation.app_navigation.AppNavigation
import ru.syndicate.fluffyclouds.ui.theme.FluffyCloudsTheme
import ru.syndicate.fluffyclouds.ui.utils.LockScreenOrientation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            FluffyCloudsTheme {

                LockScreenOrientation(
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                )

                AppNavigation()
            }
        }
    }
}