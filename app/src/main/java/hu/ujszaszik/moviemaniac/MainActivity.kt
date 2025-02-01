package hu.ujszaszik.moviemaniac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import hu.ujszaszik.moviemaniac.core.network.WebService
import hu.ujszaszik.moviemaniac.features.app.AppScreen
import hu.ujszaszik.moviemaniac.ui.theme.MovieManiacTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var webService: WebService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieManiacTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    AppScreen()
                }
            }
        }
    }
}