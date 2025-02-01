package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import hu.ujszaszik.moviemaniac.ui.theme.emptyButtonLabel
import hu.ujszaszik.moviemaniac.ui.theme.emptyTitle
import hu.ujszaszik.moviemaniac.ui.theme.paddingDouble

@Composable
fun EmptyContent(
    visible: Boolean,
    message: String = emptyTitle,
    buttonText: String = emptyButtonLabel,
    onButtonClick: () -> Unit = {}
) {
    if (visible) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(paddingDouble)
            )
            Button(onClick = onButtonClick) {
                Text(buttonText)
            }
        }
    }
}
