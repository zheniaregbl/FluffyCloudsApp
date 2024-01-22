package ru.syndicate.fluffyclouds.navigation.flight_navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.data.model.TownFlightModel
import ru.syndicate.fluffyclouds.navigation.app_navigation.ScreenRoute
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.view_model.app_view_model.AppEvent
import ru.syndicate.fluffyclouds.view_model.app_view_model.AppViewModel
import java.time.LocalDate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightNavigation(
    globalNavController: NavController,
    localNavController: NavHostController = rememberNavController(),
    scaffoldState: BottomSheetScaffoldState,
    appViewModel: AppViewModel,
    searchTown: Pair<TownFlightModel, TownFlightModel>,
    dateFlight: Pair<LocalDate?, LocalDate?>,
    peopleClassState: PeopleClassState,
    sheetState: SheetContentState
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        contentWindowInsets = WindowInsets.systemBars
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = BackgroundColor
        ) {

            FlightNavGraph(
                navController = localNavController,
                scaffoldState = scaffoldState,
                searchTown = searchTown,
                dateFlight = dateFlight,
                peopleClassState = peopleClassState,
                changeSheetContent = {
                    if (scaffoldState.bottomSheetState.targetValue != SheetValue.Expanded)
                        appViewModel.onEvent(AppEvent.ChangeSheetContentType(it))
                },
                selectFromTown = {
                    globalNavController.navigate(ScreenRoute.SelectTownFromScreen.route)
                },
                selectToTown = {
                    globalNavController.navigate(ScreenRoute.SelectTownToScreen.route)
                },
                swapTown = {
                    appViewModel.onEvent(AppEvent.SwapTown)
                },
                searchFlight = {
                    localNavController.navigate(FlightScreenRoute.FlightListScreen.route)
                }
            )
        }
    }
}