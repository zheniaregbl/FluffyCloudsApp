package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.PlainTooltipState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.ui.theme.GrayText
import ru.syndicate.fluffyclouds.ui.theme.MainBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopButton(
    modifier: Modifier,
    canSearch: Boolean,
    isEqualsTown: Boolean,
    onSearchClick: () -> Unit
) {

    val tooltipState = remember { PlainTooltipState() }
    val scope = rememberCoroutineScope()

    PlainTooltipBox(
        modifier = Modifier
            .padding(top = 16.dp)
            .width(230.dp),
        tooltip = {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        color = MainBlue.copy(alpha = 0.7f)
                    )
                    .padding(6.dp),
                text = if (isEqualsTown) "Выберите разные города" else "Введите данные для поиска",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        },
        containerColor = Color.Transparent,
        contentColor = Color.White,
        tooltipState = tooltipState
    ) {

        Box(
            modifier = modifier
                .clickable {

                    when {

                        isEqualsTown -> scope.launch { tooltipState.show() }

                        !canSearch -> scope.launch { tooltipState.show() }

                        else -> onSearchClick()
                    }
                },
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (canSearch) MainBlue else Color.White
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_search),
                    contentDescription = null,
                    tint = if (canSearch) Color.White else GrayText
                )
            }
        }
    }
}