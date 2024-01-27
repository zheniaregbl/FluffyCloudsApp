package ru.syndicate.fluffyclouds.ui.screens.profile_screen.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.syndicate.fluffyclouds.R


@Composable
fun UrlButton(
    image: Int = R.drawable.svg_tg_button,
    urlString: String = "",
    size: Dp = 50.dp
) {

    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(urlString)) }

    Image(
        modifier = Modifier
            .clip(CircleShape)
            .size(size)
            .clickable { context.startActivity(intent) },
        imageVector = ImageVector.vectorResource(id = image),
        contentDescription = null,
    )
}

@Preview
@Composable
fun PreviewUrlButton() {
    UrlButton()
}