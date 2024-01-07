package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.TownCardModel

@Composable
fun DestinationCard(
    modifier: Modifier = Modifier,
    model: TownCardModel = TownCardModel(
        image = R.drawable.destination1
    )
) {

    Box(
        modifier = modifier
    ) {

        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .height(150.dp),
            painter = painterResource(id = model.image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(
                    start = 20.dp,
                    bottom = 15.dp
                ),
            text = model.town,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}