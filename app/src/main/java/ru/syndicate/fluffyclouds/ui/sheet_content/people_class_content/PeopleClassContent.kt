package ru.syndicate.fluffyclouds.ui.sheet_content.people_class_content

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.syndicate.fluffyclouds.data.model.PeopleClassState
import ru.syndicate.fluffyclouds.ui.common.ConfirmButton
import ru.syndicate.fluffyclouds.ui.sheet_content.people_class_content.components.CategoryRow
import ru.syndicate.fluffyclouds.ui.sheet_content.people_class_content.components.ClassColumn
import ru.syndicate.fluffyclouds.ui.theme.BlackText
import ru.syndicate.fluffyclouds.ui.theme.CustomGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleClassContent(
    modifier: Modifier = Modifier,
    peopleClassState: PeopleClassState = PeopleClassState(),
    onConfirmClick: (Int, Int, Int, Int) -> Unit = {
            _: Int, _: Int, _: Int, _: Int ->
    },
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState()
) {

    val scope = rememberCoroutineScope()

    val adultState = remember {
        mutableIntStateOf(peopleClassState.adultCount)
    }
    val childrenState = remember {
        mutableIntStateOf(peopleClassState.childrenCount)
    }
    val infantState = remember {
        mutableIntStateOf(peopleClassState.infantCount)
    }

    val classIndex = remember {
        mutableIntStateOf(peopleClassState.classState)
    }

    LaunchedEffect(scaffoldState.bottomSheetState.targetValue) {

        Log.d("changeState", "update on sheet")

        adultState.intValue = peopleClassState.adultCount
        childrenState.intValue = peopleClassState.childrenCount
        infantState.intValue = peopleClassState.infantCount
        classIndex.intValue = peopleClassState.classState
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Пассажиры и классы",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = BlackText
        )

        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            CategoryRow(
                modifier = Modifier
                    .fillMaxWidth(),
                state = adultState
            )

            CategoryRow(
                modifier = Modifier
                    .fillMaxWidth(),
                categoryText = "Дети",
                categoryDescription = "От 2 до 11 лет",
                minValue = 0,
                state = childrenState
            )

            CategoryRow(
                modifier = Modifier
                    .fillMaxWidth(),
                categoryText = "Младенцы",
                categoryDescription = "Младше 2 лет, без места",
                minValue = 0,
                state = infantState
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        ClassColumn(
            modifier = Modifier
                .fillMaxWidth(),
            classState = classIndex
        )

        Spacer(
            modifier = Modifier
                .height(40.dp)
        )

        ConfirmButton(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .background(
                    color = CustomGreen
                )
                .clickable {
                    scope.launch {
                        onConfirmClick(
                            adultState.intValue, childrenState.intValue, infantState.intValue, classIndex.intValue
                        )

                        scaffoldState.bottomSheetState.hide()
                    }
                }
                .padding(
                    vertical = 16.dp
                )
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewPeopleClassContent() {
    PeopleClassContent(
        modifier = Modifier
            .fillMaxWidth()
    )
}