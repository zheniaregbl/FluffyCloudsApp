package ru.syndicate.fluffyclouds.ui.screens.info_flight_screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.common.CompanyImage
import ru.syndicate.fluffyclouds.ui.common.ConfirmButton
import ru.syndicate.fluffyclouds.ui.common.CustomSwitch
import ru.syndicate.fluffyclouds.ui.screens.info_flight_screen.components.FlightRoutePoint
import ru.syndicate.fluffyclouds.ui.theme.BackgroundBottomBar
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.ui.theme.BackgroundLightGray
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.CustomGreen
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue
import ru.syndicate.fluffyclouds.ui.theme.PayOrange
import java.text.DecimalFormat

@Composable
fun InfoFlightScreen(
    modifier: Modifier = Modifier,
    clickToBack: () -> Unit = { },
    transfers: Int = 0,
) {

    var withBag by remember {
        mutableStateOf(false)
    }
    var cost by remember {
        mutableIntStateOf(2000)
    }

    Box(
        modifier = modifier
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                )
                .padding(
                    top = 50.dp
                )
        ) {

            item {

                Column(
                    modifier = Modifier
                        .padding(
                            top = 20.dp
                        )
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    AnimatedContent(
                        targetState = cost,
                        label = "",
                        transitionSpec = {
                            fadeIn(
                                animationSpec = tween(
                                    durationMillis = 200
                                )
                            ) togetherWith fadeOut(
                                animationSpec = tween(
                                    durationMillis = 200
                                )
                            )
                        },
                    ) { value ->

                        Text(
                            text = "${DecimalFormat("#,###").format(value).replace(",", " ")}₽",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            fontSize = 36.sp,
                            color = BlackText
                        )
                    }

                    Text(
                        text = "Цена за 1 пассажира",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = GrayText
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .padding(
                            top = 16.dp
                        )
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(
                            color = Color.White
                        )
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Text(
                        text = "Информация о тарифе",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = BlackText
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.svg_accept),
                            contentDescription = null
                        )

                        Text(
                            text = "Ручная кладь 1x10 кг",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = BlackText
                        )
                    }

                    AnimatedContent(
                        targetState = withBag,
                        label = "",
                        transitionSpec = {
                            fadeIn() togetherWith fadeOut()
                        }
                    ) { withBag ->

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            if (withBag) {

                                Image(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_accept),
                                    contentDescription = null
                                )

                            } else {

                                Box(
                                    modifier = Modifier
                                        .size(16.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Icon(
                                        modifier = Modifier
                                            .size(10.dp),
                                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_cancel),
                                        contentDescription = null,
                                        tint = GrayText
                                    )
                                }
                            }

                            Text(
                                text = if (withBag) "С багажом" else "Без багажа",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = BlackText
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .background(
                                color = BackgroundLightGray
                            )
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = buildAnnotatedString {

                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                        color = BlackText
                                    )
                                ) {
                                    append("Добавить багаж")
                                }

                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                        color = MainBlue
                                    )
                                ) {
                                    append(" +1 073₽")
                                }
                            }
                        )

                        CustomSwitch(
                            switchPadding = 2.dp,
                            buttonWidth = 44.dp,
                            buttonHeight = 24.dp,
                            value = withBag,
                            onSwitch = {
                                withBag = !withBag

                                if (withBag) cost += 1073 else cost -= 1073
                            }
                        )
                    }
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .padding(
                            top = 20.dp,
                            bottom = 16.dp
                        )
                ) {

                    Text(
                        text = "Москва - Сочи",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = BlackText
                    )

                    Text(
                        text = "4ч в пути",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = GrayText
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(
                            color = Color.White
                        )
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    for (i in 0 until transfers + 1) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    CompanyImage(
                                        modifier = Modifier,
                                        url = "https://nqzgkeopbshaepraaexh.supabase.co/storage/v1/object/public/company/company_aeroflot.png",
                                        imageSize = 32.dp
                                    )

                                    Column {

                                        Text(
                                            text = "Аэрофлот",
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 14.sp,
                                            color = BlackText
                                        )

                                        Text(
                                            text = "4ч в полете",
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 14.sp,
                                            color = GrayText
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(
                                            color = BackgroundLightGray
                                        )
                                        .clickable { }
                                        .padding(
                                            horizontal = 10.dp,
                                            vertical = 4.dp
                                        )
                                ) {

                                    Text(
                                        text = "Подробнее",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 12.sp,
                                        color = BlackText
                                    )
                                }
                            }

                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {

                                Column {
                                    FlightRoutePoint()

                                    FlightRoutePoint(
                                        isLast = true
                                    )
                                }

                                if (i != transfers)
                                    Row(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .fillMaxWidth()
                                            .background(
                                                color = BackgroundLightGray
                                            )
                                            .padding(10.dp),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Icon(
                                            modifier = Modifier
                                                .size(22.dp),
                                            imageVector = ImageVector.vectorResource(id = R.drawable.svg_transfer),
                                            contentDescription = null,
                                            tint = GrayText
                                        )

                                        Column(
                                            verticalArrangement = Arrangement.spacedBy(2.dp)
                                        ) {

                                            Text(
                                                text = "Пересадка в Стамбуле",
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 14.sp,
                                                color = BlackText
                                            )

                                            Text(
                                                text = "1ч 00м",
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 14.sp,
                                                color = GrayText
                                            )
                                        }
                                    }
                            }
                        }
                    }
                }
            }

            item {

                Spacer(
                    modifier = Modifier
                        .height(90.dp)
                )
            }
        }

        ConfirmButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = 16.dp
                )
                .padding(
                    horizontal = 20.dp
                )
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .background(
                    color = PayOrange
                )
                .clickable { }
                .padding(
                    vertical = 16.dp
                ),
            text = "Купить за 2 000₽"
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shadowElevation = 8.dp,
            color = Color.White
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 14.dp
                    )
            ) {

                Row(
                    modifier = Modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) { clickToBack() },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Icon(
                        modifier = Modifier
                            .size(18.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_arrow_back),
                        contentDescription = null,
                        tint = MainBlue
                    )

                    Text(
                        text = "Назад",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium,
                        color = MainBlue
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewInfoFlightScreen() {
    InfoFlightScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = BackgroundColor
            )
    )
}

@Preview
@Composable
fun PreviewInfoFlightScreenWithTransfers() {
    InfoFlightScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = BackgroundColor
            ),
        transfers = 2
    )
}