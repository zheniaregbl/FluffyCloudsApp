package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.TownTextFieldType
import ru.syndicate.fluffyclouds.extensions.containsUnwantedChar
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TownTextField(
    modifier: Modifier = Modifier,
    townTextFieldType: TownTextFieldType = TownTextFieldType.FROM,
    textState: MutableState<String> = mutableStateOf("")
) {

    OutlinedTextField(
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
    )
}

@Preview
@Composable
fun PreviewTownTextField() {
    TownTextField(
        modifier = Modifier
            .fillMaxWidth()
    )
}