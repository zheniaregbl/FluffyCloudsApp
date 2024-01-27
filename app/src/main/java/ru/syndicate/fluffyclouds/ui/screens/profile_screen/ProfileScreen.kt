package ru.syndicate.fluffyclouds.ui.screens.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.screens.profile_screen.components.ProfileTopBar
import ru.syndicate.fluffyclouds.ui.screens.profile_screen.components.SettingParamItem
import ru.syndicate.fluffyclouds.ui.screens.profile_screen.components.UrlButton
import ru.syndicate.fluffyclouds.ui.theme.BackgroundColor
import ru.syndicate.fluffyclouds.ui.theme.BlackText

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                )
        ) {

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 74.dp
                        )
                ) {

                    Text(
                        text = "Профиль",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )

                    SettingParamItem(
                        modifier = Modifier
                            .padding(
                                top = 10.dp
                            )
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                color = Color.White
                            )
                            .clickable { }
                            .padding(
                                vertical = 14.dp,
                                horizontal = 10.dp
                            ),
                        textParam = "Персональные данные"
                    )

                    SettingParamItem(
                        modifier = Modifier
                            .padding(
                                top = 8.dp
                            )
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                color = Color.White
                            )
                            .clickable { }
                            .padding(
                                vertical = 14.dp,
                                horizontal = 10.dp
                            ),
                        textParam = "Платежные данные"
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 16.dp
                        )
                ) {

                    Text(
                        text = "Настройки",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )

                    SettingParamItem(
                        modifier = Modifier
                            .padding(
                                top = 10.dp
                            )
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                color = Color.White
                            )
                            .clickable { }
                            .padding(
                                vertical = 14.dp,
                                horizontal = 10.dp
                            ),
                        textParam = "Отображение валют"
                    )

                    SettingParamItem(
                        modifier = Modifier
                            .padding(
                                top = 8.dp
                            )
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                color = Color.White
                            )
                            .clickable { }
                            .padding(
                                vertical = 14.dp,
                                horizontal = 10.dp
                            ),
                        textParam = "Приватность"
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 16.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Text(
                        text = "Связаться с нами",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        UrlButton(
                            image = R.drawable.svg_tg_button,
                            urlString = "https://web.telegram.org/k/",
                            size = 40.dp
                        )

                        UrlButton(
                            image = R.drawable.svg_vk_button,
                            urlString = "https://vk.com/feed",
                            size = 40.dp
                        )

                        UrlButton(
                            image = R.drawable.svg_fluffy_button,
                            urlString = "https://github.com/zheniaregbl/FluffyCloudsApp",
                            size = 40.dp
                        )
                    }
                }
            }
        }

        ProfileTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White
                ),
            userName = "Гость"
        )
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = BackgroundColor
            )
    )
}