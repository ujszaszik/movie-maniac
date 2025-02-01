package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import hu.ujszaszik.moviemaniac.ui.theme.Typography

@Composable
fun LabeledText(label: String, value: String) {
    Text(
        text = "$label: $value",
        style = Typography.bodySmall
    )
}