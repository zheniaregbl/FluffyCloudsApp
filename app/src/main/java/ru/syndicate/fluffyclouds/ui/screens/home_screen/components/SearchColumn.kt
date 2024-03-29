package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor

@Composable
fun SearchColumn(
    modifier: Modifier = Modifier,
    fromTownTextState: MutableState<String> = mutableStateOf(""),
    toTownTextState: MutableState<String> = mutableStateOf(""),
    onSwapClick: () -> Unit = { }
) {

    val listFocusRequester = listOf(
        FocusRequester(), FocusRequester()
    )
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp
                        )
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            color = Color.White
                        )
                ) {

                    TownTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                end = 80.dp
                            )
                            .focusRequester(listFocusRequester.first()),
                        textState = fromTownTextState,
                        textHint = "Откуда",
                        image = R.drawable.svg_from
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp
                        )
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            color = Color.White
                        )
                ) {

                    TownTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                end = 80.dp
                            )
                            .focusRequester(listFocusRequester.last()),
                        textState = toTownTextState,
                        textHint = "Куда",
                        image = R.drawable.svg_to
                    )
                }
            }

            SwapButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(
                        end = 40.dp
                    )
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(
                        color = BackgroundColor
                    ),
                onClick = {
                    onSwapClick()
                    focusManager.clearFocus()
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewSearchColumn() {
    SearchColumn(
        modifier = Modifier
            .fillMaxWidth()
    )
}