package ru.syndicate.fluffyclouds.ui.screens.register_screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import ru.syndicate.fluffyclouds.extensions.isNetworkAvailable
import ru.syndicate.fluffyclouds.extensions.isValidEmail
import ru.syndicate.fluffyclouds.ui.screens.register_screen.components.PasswordRegisterTextField
import ru.syndicate.fluffyclouds.ui.screens.register_screen.components.RegisterTextField
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue
import ru.syndicate.fluffyclouds.view_model.registration_view_model.RegistrationEvent
import ru.syndicate.fluffyclouds.view_model.registration_view_model.RegistrationViewModel

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    isRegister: Boolean = true,
    navigateToRegister: () -> Unit = { },
    navigateToAuth: () -> Unit = { },
    navigateToHome: () -> Unit = { }
) {

    val viewModel = hiltViewModel<RegistrationViewModel>()
    val state by viewModel.state.collectAsState()

    val context = LocalContext.current

    LaunchedEffect(state) {

        if (state.enter) {
            Log.d("checkRegisterToken", "go to home screen")
            delay(250)
            navigateToHome()
        }
    }

    val emailText = remember {
        mutableStateOf("")
    }
    val passwordText = remember {
        mutableStateOf("")
    }
    val repeatPasswordText = remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 12.dp
                )
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

            Spacer(
                modifier = Modifier
                    .height(120.dp)
            )

            Text(
                text = if (isRegister) "Регистрация" else "Вход в аккаунт",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                color = BlackText
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            RegisterTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                text = emailText,
                placeholderText = "Email"
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            PasswordRegisterTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                text = passwordText,
                placeholderText = "Пароль"
            )

            if (isRegister) {

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                PasswordRegisterTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = repeatPasswordText,
                    placeholderText = "Повторите пароль"
                )
            }

            if (!isRegister)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 10.dp
                        ),
                    horizontalArrangement = Arrangement.End
                ) {

                    ClickableText(
                        text = AnnotatedString(
                            text = "Забыли пароль?"
                        ),
                        onClick = { },
                        style = TextStyle(
                            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = GrayText
                        )
                    )
                }

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
                    .clickable {

                        when {

                            !context.isNetworkAvailable() -> Toast
                                .makeText(
                                    context,
                                    "Нет соединения",
                                    Toast.LENGTH_LONG
                                )
                                .show()

                            emailText.value.isEmpty() -> Toast
                                .makeText(
                                    context,
                                    "Пустой email",
                                    Toast.LENGTH_LONG
                                )
                                .show()

                            !emailText.value.isValidEmail() -> Toast
                                .makeText(
                                    context,
                                    "Не валидный email",
                                    Toast.LENGTH_LONG
                                )
                                .show()

                            passwordText.value.isEmpty() -> Toast
                                .makeText(
                                    context,
                                    "Пароль пуст",
                                    Toast.LENGTH_LONG
                                )
                                .show()

                            else -> if (!isRegister) {
                                viewModel.onEvent(
                                    RegistrationEvent.Authorization(
                                        emailText.value,
                                        passwordText.value,
                                        context
                                    )
                                )
                            } else {

                                if (passwordText.value == repeatPasswordText.value &&
                                    passwordText.value.isNotEmpty()
                                ) {

                                    viewModel.onEvent(
                                        RegistrationEvent.Registration(
                                            emailText.value,
                                            passwordText.value,
                                            context
                                        )
                                    )

                                } else {
                                    Toast
                                        .makeText(
                                            context,
                                            "Неверный пароль",
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                }
                            }
                        }

                    }
                    .padding(
                        vertical = 14.dp
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = if (isRegister) "Зарегистрироваться" else "Войти",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = 20.dp
                ),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = if (isRegister) "Уже есть аккаунт?" else "Нет аккаунта?",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = GrayText
            )

            Spacer(
                modifier = Modifier
                    .width(3.dp)
            )

            ClickableText(
                text = AnnotatedString(
                    text = if (isRegister) "Войти" else "Создать"
                ),
                onClick = {
                    if (isRegister) navigateToAuth() else navigateToRegister()
                },
                style = TextStyle(
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = MainBlue
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}