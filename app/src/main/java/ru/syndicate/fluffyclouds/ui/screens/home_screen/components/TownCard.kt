package ru.syndicate.fluffyclouds.ui.screens.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.TownCardModel
import ru.syndicate.fluffyclouds.ui.theme.BlackText

@Composable
fun TownCard(
    modifier: Modifier = Modifier,
    townCardModel: TownCardModel = TownCardModel()
) {

    Column(
        modifier = modifier
    ) {

        Image(
            modifier = Modifier
                .size(150.dp, 200.dp),
            painter = painterResource(id = townCardModel.image),
            contentDescription = null,
        )

        Text(
            modifier = Modifier
                .padding(10.dp),
            text = townCardModel.town,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = BlackText
        )
    }
}

@Preview
@Composable
fun PreviewTownCard() {
    TownCard(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = Color.White
            )
    )
}