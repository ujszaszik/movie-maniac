package hu.ujszaszik.moviemaniac.features.movies.data.repository

interface IMoviesRepository {

    suspend fun getMovies(page: Long): List<MovieData>
}