package hu.ujszaszik.moviemaniac.features.movies.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.ujszaszik.moviemaniac.BuildConfig
import hu.ujszaszik.moviemaniac.core.ui.RemoteImage
import hu.ujszaszik.moviemaniac.features.movies.domain.MovieUiModel

@Composable
fun MovieItemScreen(movie: MovieUiModel) {
    Column(
        modifier = Modifier.padding(1.dp)
    ) {
        RemoteImage(
            imageUrl = movie.imageUrl,
            apiKey = BuildConfig.API_KEY
        )

        Text(
            text = movie.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxHeight(),
            maxLines = 2,
            minLines = 2
        )

        Text(text = "Rating: ${movie.rating}", fontSize = 12.sp)
        Text(text = "Revenue: ${movie.revenue}", fontSize = 12.sp)
        Text(text = "Budget: ${movie.budget}", fontSize = 12.sp)
    }
}