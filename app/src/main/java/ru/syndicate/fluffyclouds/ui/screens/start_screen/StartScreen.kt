package ru.syndicate.fluffyclouds.ui.screens.start_screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navigateToRegister: () -> Unit = { },
    navigateToAuth: () -> Unit = { },
) {

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Fluffy",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = BlackText
                )

                Spacer(
                    modifier = Modifier
                        .width(10.dp)
                )

                Text(
                    text = "Clouds",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MainBlue,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        modifier = Modifier
                            .padding(
                                vertical = 56.dp
                            )
                            .size(
                                width = 184.dp,
                                height = 258.dp
                            ),
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_logo),
                        contentDescription = null,
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 12.dp
                        )
                ) {

                    Text(
                        text = "Добро пожаловать!",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = BlackText
                    )

                    Spacer(
                        modifier = Modifier
                            .height(6.dp)
                    )

                    Text(
                        text = "Пройдите регистрацию или войдите в аккаунт чтобы пользоваться приложением.",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText,
                        lineHeight = 22.sp
                    )

                    Spacer(
                        modifier = Modifier
                            .height(30.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                color = MainBlue
                            )
                            .clickable { navigateToRegister() }
                            .padding(
                                vertical = 14.dp
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "Зарегистрироваться",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(
                                width = 2.dp,
                                color = MainBlue,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable { navigateToAuth() }
                            .padding(
                                vertical = 14.dp
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "Войти",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = MainBlue
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewStartScreen() {
    StartScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}