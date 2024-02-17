package ru.syndicate.fluffyclouds.navigation.app_navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.syndicate.fluffyclouds.data.model.SheetContentState
import ru.syndicate.fluffyclouds.navigation.utils.getCurrentRoute
import ru.syndicate.fluffyclouds.ui.bottom_navigation_bar.BottomBar
import ru.syndicate.fluffyclouds.ui.sheet_content.calendar_content.CalendarContent
import ru.syndicate.fluffyclouds.ui.sheet_content.people_class_content.PeopleClassContent
import ru.syndicate.fluffyclouds.ui.theme.BackgroundBottomBar
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.view_model.app_view_model.AppEvent
import ru.syndicate.fluffyclouds.view_model.app_view_model.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    val appViewModel = hiltViewModel<AppViewModel>()
    val searchTown by appViewModel.searchTowns.collectAsState()
    val dateFlight by appViewModel.dateFlight.collectAsState()
    val peopleClassState by appViewModel.peopleClassState.collectAsState()
    val sheetState by appViewModel.sheetContentState.collectAsState()

    val routeList = listOf(
        FlightScreenRoute.HomeScreen.route,
        FlightScreenRoute.FlightListScreen.route,
        ScreenRoute.TicketScreen.route,
        ScreenRoute.ProfileScreen.route
    )

    val currentRoute = getCurrentRoute(navController = navController)

    val showNavigationMenu = navController
        .currentBackStackEntryAsState().value?.destination?.route in routeList.map { it }

    val selectedTabIndex = remember {
        mutableIntStateOf(0)
    }

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    )

    BottomSheetScaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState,
        sheetContent = {

            AnimatedVisibility(
                visible = sheetState == SheetContentState.CALENDAR,
                enter = EnterTransition.None,
                exit = ExitTransition.None
            ) {

                CalendarContent(
                    modifier = Modifier
                        .fillMaxWidth(),
                    dateFlight = dateFlight,
                    onConfirmClick = { dateFrom, dateTo ->
                        appViewModel.onEvent(
                            AppEvent.ChangeFlightDate(
                                dateFrom, dateTo
                            )
                        )
                    },
                    scaffoldState = scaffoldState
                )
            }

            AnimatedVisibility(
                visible = sheetState == SheetContentState.PEOPLE,
                enter = EnterTransition.None,
                exit = ExitTransition.None
            ) {
                PeopleClassContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp
                        ),
                    peopleClassState = peopleClassState,
                    onConfirmClick = { adult, children, infant, classIndex ->

                        Log.d("changeState", adult.toString())

                        appViewModel.onEvent(
                            AppEvent.ChangePeopleClass(
                                adult = adult,
                                children = children,
                                infant = infant,
                                indexClass = classIndex
                            )
                        )
                    },
                    scaffoldState = scaffoldState
                )
            }
        },
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetPeekHeight = 0.dp,
        sheetContainerColor = when (sheetState) {
            SheetContentState.CALENDAR -> BackgroundColor
            SheetContentState.PEOPLE -> Color.White
        }
    ) {

        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            bottomBar = {

                if (showNavigationMenu)
                    BottomBar(
                        modifier = Modifier
                            .padding(
                                vertical = 30.dp,
                                horizontal = 50.dp
                            )
                            .fillMaxWidth()
                            .height(60.dp)
                            .clip(CircleShape)
                            .background(
                                color = BackgroundBottomBar
                            ),
                        navController = navController,
                        selectedTabIndex = selectedTabIndex
                    )
            },
            contentWindowInsets = WindowInsets.systemBars
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = BackgroundColor
            ) {

                AppNavGraph(
                    appNavController = navController,
                    scaffoldState = scaffoldState,
                    appViewModel = appViewModel,
                    searchTown = searchTown,
                    dateFlight = dateFlight,
                    peopleClassState = peopleClassState
                )
            }
        }

        AnimatedVisibility(
            visible = scaffoldState.bottomSheetState.targetValue == SheetValue.Expanded,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.Black.copy(alpha = 0.3f)
                    )
            )
        }
    }
}