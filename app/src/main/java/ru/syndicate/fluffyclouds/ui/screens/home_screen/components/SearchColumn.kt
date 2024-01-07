package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.TownTextFieldType
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.ui.theme.CircleBlack
import ru.syndicate.fluffyclouds.ui.theme.GrayText

@Composable
fun SearchColumn(
    modifier: Modifier = Modifier,
    fromTownTextState: MutableState<String> = mutableStateOf(""),
    toTownTextState: MutableState<String> = mutableStateOf(""),
    onSwapClick: () -> Unit = { }
) {

    var flagStartPosition by remember {
        mutableStateOf(true)
    }
    val rotate by animateIntAsState(
        targetValue = if (flagStartPosition) 0 else 180,
        animationSpec = tween(
            durationMillis = 180,
            easing = Ease
        ),
        label = ""
    )

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
                            ),
                        townTextFieldType = TownTextFieldType.FROM,
                        textState = fromTownTextState
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
                            ),
                        townTextFieldType = TownTextFieldType.TO,
                        textState = toTownTextState
                    )
                }
            }

            Box(
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
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(
                            color = CircleBlack
                        )
                        .graphicsLayer {
                            rotationZ = rotate.toFloat()
                        }
                        .clickable {
                            flagStartPosition = !flagStartPosition
                            onSwapClick()
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_swap),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            item {
                SearchChip(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .background(
                            color = Color.White
                        )
                        .padding(14.dp),
                    textColor = GrayText,
                    icon = R.drawable.svg_calendar,
                    text = "Даты"
                )
            }

            item {
                Spacer(
                    modifier = Modifier
                        .width(10.dp)
                )
            }

            item {
                SearchChip(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .background(
                            color = Color.White
                        )
                        .padding(14.dp),
                    textColor = GrayText,
                    icon = R.drawable.svg_people,
                    text = "1, эконом"
                )
            }
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