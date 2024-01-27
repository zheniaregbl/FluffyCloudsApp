package ru.syndicate.fluffyclouds.ui.screens.ticket_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.ui.theme.BlackText

@Composable
fun TicketCard(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "МСК",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText
                )

                Text(
                    text = "—",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText
                )

                Text(
                    text = "УФА",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Medium,
                    color = BlackText
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    Text(
                        text = "Дата",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )

                    Text(
                        text = "01.02.2024",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    Text(
                        text = "Место",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )

                    Text(
                        text = "12",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    Text(
                        text = "Пассажир",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )

                    Text(
                        text = "Иванов И.И.",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Text(
                        text = "Класс",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )

                    Text(
                        text = "Бизнес",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Text(
                        text = "Посадка",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )

                    Text(
                        text = "11:30",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlackText
                    )
                }

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .width(1.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTicketCard() {
    TicketCard(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(
                color = Color.White
            )
            .padding(16.dp)
    )
}