package ru.syndicate.fluffyclouds.ui.screens.register_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.extensions.containsUnwantedChar
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.CustomGray
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterTextField(
    modifier: Modifier,
    text: MutableState<String>,
    placeholderText: String
) {

    OutlinedTextField(
        modifier = modifier,
        value = text.value,
        onValueChange = { newText ->
            if (!newText.containsUnwantedChar())
                text.value = newText
        },
        textStyle = TextStyle(
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            color = BlackText
        ),
        placeholder = {
            Text(
                text = placeholderText,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = GrayText
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = CustomGray,
            cursorColor = MainBlue,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            selectionColors = TextSelectionColors(
                handleColor = MainBlue,
                backgroundColor = MainBlue.copy(alpha = 0.4f)
            )
        ),
        shape = RoundedCornerShape(8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordRegisterTextField(
    modifier: Modifier,
    text: MutableState<String>,
    placeholderText: String
) {

    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = text.value,
        onValueChange = { newText ->
            if (!newText.containsUnwantedChar())
                text.value = newText
        },
        textStyle = TextStyle(
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            color = BlackText
        ),
        placeholder = {
            Text(
                text = placeholderText,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = GrayText
            )
        },
        trailingIcon = {

            val icon = if (passwordVisible) R.drawable.svg_show_password 
                    else R.drawable.svg_hide_password

            IconButton(
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp
                    )
                    .size(30.dp),
                onClick = { passwordVisible = !passwordVisible }
            ) {

                Icon(
                    imageVector = ImageVector.vectorResource(id = icon),
                    contentDescription = null
                )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = CustomGray,
            cursorColor = MainBlue,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            selectionColors = TextSelectionColors(
                handleColor = MainBlue,
                backgroundColor = MainBlue.copy(alpha = 0.4f)
            ),
            focusedTrailingIconColor = BlackText,
            unfocusedTrailingIconColor = GrayText
        ),
        shape = RoundedCornerShape(8.dp)
    )
}