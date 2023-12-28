package ru.syndicate.fluffyclouds.ui.screens.home_screen

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import ru.syndicate.fluffyclouds.data.model.Airplane
import ru.syndicate.fluffyclouds.extensions.containsUnwantedChar
import ru.syndicate.fluffyclouds.info_functions.generatePDF
import ru.syndicate.fluffyclouds.info_functions.requestForegroundPermission
import ru.syndicate.fluffyclouds.ui.theme.MainBlue
import ru.syndicate.fluffyclouds.view_model.home_view_model.HomeEvent
import ru.syndicate.fluffyclouds.view_model.home_view_model.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    requestForegroundPermission(context)

    val viewModel = hiltViewModel<HomeViewModel>()
    val listAirplane = viewModel.airplaneList.observeAsState()

    val listModels = listOf(
        "Все", "ИЛ-86", "ТУ-154", "Superjet-100", "ИЛ-62",
        "МС-21", "ИЛ-96", "КР-860", "ТУ-204"
    )

    var textSearch by remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = textSearch,
                    onValueChange = {
                        if (!it.containsUnwantedChar())
                            textSearch = it
                    },
                    textStyle = TextStyle(
                        fontSize = 15.sp
                    ),
                    placeholder = {
                        Text(
                            text = "Введие модель самолета",
                            fontSize = 15.sp,
                            color = Color.Black.copy(alpha = 0.4f)
                        )
                    },
                    singleLine = true
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            color = MainBlue
                        )
                        .clickable { viewModel.onEvent(HomeEvent.SearchAirplane(textSearch)) }
                        .padding(
                            vertical = 10.dp
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Поиск",
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(listModels) {
                    Spacer(
                        modifier = Modifier
                            .width(4.dp)
                    )

                    FilterButton(
                        text = it,
                        onClick = {
                            if (it == "Все")
                                viewModel.onEvent(HomeEvent.FilterAirplane(""))
                            else
                                viewModel.onEvent(HomeEvent.FilterAirplane(it))
                        }
                    )

                    Spacer(
                        modifier = Modifier
                            .width(4.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 10.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listAirplane.value ?: listOf()) {
                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                    )

                    AirplaneCard(
                        airplane = it
                    )

                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = 30.dp,
                    end = 30.dp
                )
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        color = MainBlue
                    )
                    .clickable { generatePDF(context, listAirplane.value ?: listOf()) }
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "PDF",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun FilterButton(
    text: String = "Все",
    onClick: () -> Unit = { }
) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black
            )
            .clickable { onClick() }
            .padding(10.dp)
    ) {
        Text(
            text = text
        )
    }
}


@Composable
fun AirplaneCard(
    airplane: Airplane = Airplane()
) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = airplane.id.toString()
        )

        Text(
            text = airplane.model
        )

        Text(
            text = airplane.quantitySeat.toString()
        )
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}


private const val REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE = 34

