package ru.syndicate.fluffyclouds.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
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
import ru.syndicate.fluffyclouds.view_model.sheet_view_model.SheetEvent
import ru.syndicate.fluffyclouds.view_model.sheet_view_model.SheetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
) {

    val sheetViewModel = hiltViewModel<SheetViewModel>()
    val peopleClassState by sheetViewModel.peopleClassState.collectAsState()
    val sheetState by sheetViewModel.sheetContentState.collectAsState()

    val routeList = listOf(
        ScreenRoute.HomeScreen.route
    )

    val currentRoute = getCurrentRoute(navController = navController)

    val showNavigationMenu = navController
        .currentBackStackEntryAsState().value?.destination?.route in routeList.map { it }

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    )

    val shadowColor by animateColorAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == SheetValue.Expanded) Color.Black.copy(
            alpha = 0.3f
        )
        else Color.Transparent,
        animationSpec = tween(
            durationMillis = 400,
            easing = Ease
        ),
        label = "shadow"
    )

    BottomSheetScaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState,
        sheetContent = {

            AnimatedContent(
                targetState = sheetState,
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                },
                label = ""
            ) { state ->

                when (state) {

                    SheetContentState.CALENDAR -> {
                        CalendarContent(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                        )
                    }

                    SheetContentState.PEOPLE -> {
                        PeopleClassContent(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 20.dp
                                ),
                            peopleClassState = peopleClassState,
                            onConfirmClick = { adult, children, infant, classIndex ->

                                Log.d("changeState", adult.toString())

                                sheetViewModel.onEvent(
                                    SheetEvent.ChangePeopleClass(
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
                }
            }
        },
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetPeekHeight = 0.dp,
        sheetContainerColor = Color.White
    ) {


        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            contentWindowInsets = WindowInsets.systemBars,
            bottomBar = {

                if (showNavigationMenu)
                    BottomBar(
                        modifier = Modifier
                            .padding(
                                vertical = 50.dp,
                                horizontal = 50.dp
                            )
                            .fillMaxWidth()
                            .height(60.dp)
                            .clip(CircleShape)
                            .background(
                                color = BackgroundBottomBar
                            )
                    )
            }
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = Color.White
            ) {

                AppNavGraph(
                    navController = navController,
                    scaffoldState = scaffoldState,
                    peopleClassState = peopleClassState,
                    changeSheetContent = {
                        sheetViewModel.onEvent(SheetEvent.ChangeSheetContentType(it))
                    }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = shadowColor
                )
        )
    }
}