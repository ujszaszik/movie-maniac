package hu.ujszaszik.moviemaniac.features.filters.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import hu.ujszaszik.moviemaniac.ui.theme.DefaultButtonShape
import hu.ujszaszik.moviemaniac.ui.theme.Typography
import hu.ujszaszik.moviemaniac.ui.theme.defaultCardHeight
import hu.ujszaszik.moviemaniac.ui.theme.defaultPadding
import hu.ujszaszik.moviemaniac.ui.theme.filterBgColor

@Composable
fun FilterItemScreen(item: Genre, onClick: (Genre) -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {

        Button(
            onClick = { onClick.invoke(item) },
            shape = DefaultButtonShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (item.isSelected) Color.Black else filterBgColor,
                contentColor = Color.White
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(defaultPadding)
                .height(defaultCardHeight)
        ) {
            Text(
                text = item.name,
                style = Typography.bodyMedium
            )
        }
    }
}