package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.extensions.containsUnwantedChar
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@Composable
fun TownTextField(
    modifier: Modifier = Modifier,
    textState: MutableState<String> = mutableStateOf(""),
    textHint: String = "Откуда",
    image: Int = R.drawable.svg_from
) {

    val customTextSelectionColors = TextSelectionColors(
        handleColor = MainBlue,
        backgroundColor = MainBlue
    )

    BasicTextField(
        modifier = modifier,
        value = textState.value,
        onValueChange = {
            if (!it.containsUnwantedChar())
                textState.value = it
        },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            color = BlackText,
            fontSynthesis = FontSynthesis.None
        ),
        singleLine = true,
        cursorBrush = SolidColor(MainBlue),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    ) { innerTextField ->

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .background(
                    color = Color.White
                )
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = ImageVector.vectorResource(id = image),
                contentDescription = null,
                tint = if (textState.value.isNotEmpty()) BlackText else GrayText
            )

            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )

            CompositionLocalProvider(
                LocalTextSelectionColors provides customTextSelectionColors
            ) {

                Box {
                    if (textState.value.isEmpty())
                        Text(
                            text = textHint,
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = GrayText
                        )

                    SelectionContainer {
                        innerTextField()
                    }
                }
            }
        }
    }

    /*OutlinedTextField(
        modifier = modifier,
        value = textState.value,
        onValueChange = {
            if (!it.containsUnwantedChar())
                textState.value = it
        },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            color = BlackText,
            fontSynthesis = FontSynthesis.None
        ),
        placeholder = {
            Text(
                text = if (townTextFieldType == TownTextFieldType.FROM) "Откуда"
                    else "Куда",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = GrayText
            )
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = if (townTextFieldType == TownTextFieldType.FROM) R.drawable.svg_from
                        else R.drawable.svg_to
                ),
                contentDescription = null,
                tint = GrayText
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(6.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            cursorColor = MainBlue,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            selectionColors = TextSelectionColors(
                handleColor = MainBlue,
                backgroundColor = MainBlue.copy(alpha = 0.4f)
            )
        )
    )*/
}

@Preview
@Composable
fun PreviewTownTextField() {
    TownTextField(
        modifier = Modifier
            .fillMaxWidth()
    )
}