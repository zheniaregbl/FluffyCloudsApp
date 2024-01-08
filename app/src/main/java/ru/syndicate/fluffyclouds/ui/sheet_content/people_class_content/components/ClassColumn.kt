package ru.syndicate.fluffyclouds.ui.sheet_content.people_class_content.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.BorderRadio

@Composable
fun ClassColumn(
    modifier: Modifier = Modifier,
    classOptions: List<String> = listOf("Эконом", "Комфорт", "Бизнес", "Первый класс"),
    classState: MutableState<Int> = mutableIntStateOf(1)
) {

    Column(
        modifier = modifier
            .selectableGroup()
    ) {

        classOptions.forEachIndexed { index, label ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            classState.value = index
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )

                    CustomRadioButton(
                        isSelected = classState.value == index
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                if (index != classOptions.lastIndex) {

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(
                                color = BorderRadio
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewClassColumn() {
    ClassColumn(
        modifier = Modifier
            .fillMaxWidth()
    )
}