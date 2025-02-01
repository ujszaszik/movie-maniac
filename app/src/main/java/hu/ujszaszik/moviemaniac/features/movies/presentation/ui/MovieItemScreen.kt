package hu.ujszaszik.moviemaniac.features.movies.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.ujszaszik.moviemaniac.BuildConfig
import hu.ujszaszik.moviemaniac.core.ui.LabeledText
import hu.ujszaszik.moviemaniac.core.ui.RemoteImage
import hu.ujszaszik.moviemaniac.features.movies.domain.MovieUiModel
import hu.ujszaszik.moviemaniac.ui.theme.Typography
import hu.ujszaszik.moviemaniac.ui.theme.budgetLabel
import hu.ujszaszik.moviemaniac.ui.theme.paddingDefault
import hu.ujszaszik.moviemaniac.ui.theme.paddingMinimum
import hu.ujszaszik.moviemaniac.ui.theme.ratingLabel
import hu.ujszaszik.moviemaniac.ui.theme.revenueLabel

@Composable
fun MovieItemScreen(movie: MovieUiModel) {
    Column(
        modifier = Modifier.padding(paddingMinimum)
    ) {
        RemoteImage(
            imageUrl = movie.imageUrl,
            apiKey = BuildConfig.API_KEY
        )

        Text(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = paddingDefault),
            text = movie.title,
            style = Typography.titleMedium,
            maxLines = 2,
            minLines = 2,
        )

        LabeledText(label = ratingLabel, value = movie.rating)
        LabeledText(label = revenueLabel, value = movie.revenue)
        LabeledText(label = budgetLabel, value = movie.budget)
    }
}