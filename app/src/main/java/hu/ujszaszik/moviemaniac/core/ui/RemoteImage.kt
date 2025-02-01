package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import hu.ujszaszik.moviemaniac.R

@Composable
fun RemoteImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    apiKey: String,
    description: String? = null
) {
    val imagePainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .crossfade(true)
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
            Image(
                painter = painterResource(R.drawable.ic_placeholder),
                contentDescription = description,
                modifier = modifier
            )
        }
    }
}