package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun EditIcon(onEdit: () -> Unit) {
    FloatingActionButton(onClick = onEdit) {
        Icon(
            Icons.Default.Edit,
            contentDescription = null
        )
    }
}