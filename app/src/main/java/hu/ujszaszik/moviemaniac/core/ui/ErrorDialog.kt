package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import hu.ujszaszik.moviemaniac.ui.theme.errorButtonLabel
import hu.ujszaszik.moviemaniac.ui.theme.errorMessageDefault
import hu.ujszaszik.moviemaniac.ui.theme.errorTitle

@Composable
fun ErrorDialog(
    showError: Boolean,
    error: Throwable?,
    onDismiss: () -> Unit
) {
    if (showError) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(errorTitle) },
            text = { Text(error?.message ?: errorMessageDefault) },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text(errorButtonLabel)
                }
            }
        )
    }
}
