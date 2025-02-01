package hu.ujszaszik.moviemaniac.core.network

import hu.ujszaszik.moviemaniac.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import javax.inject.Inject

class WebService @Inject constructor(val client: HttpClient) {

    suspend inline fun <reified T> get(
        path: String = "", block: HttpRequestBuilder.() -> Unit = {}
    ): T {
        return client.get("$BASE_URL$path") {
            header(AUTHORIZATION_HEADER, TOKEN)
            block()
        }.body()
    }

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/original"
        const val AUTHORIZATION_HEADER = "Authorization"
        const val TOKEN = "Bearer ${BuildConfig.API_KEY}"
    }
}