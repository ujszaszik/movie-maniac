package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun RemoteImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    apiKey: String,
    description: String? = null
) {
    val imagePainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .addHeader("Authorization", "Bearer $apiKey")
            .size(Size.ORIGINAL).build()
    )

    when (imagePainter.state) {
        is AsyncImagePainter.State.Loading -> {
            CircularProgressIndicator()
        }

        is AsyncImagePainter.State.Success -> {
            Image(
                painter = imagePainter,
                contentDescription = description,
                modifier = modifier
            )
        }

        else -> {
            Text("ERROR")
        }
    }
}