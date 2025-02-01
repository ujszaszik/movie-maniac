package hu.ujszaszik.moviemaniac.features.movies.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.ujszaszik.moviemaniac.features.movies.data.remote.MovieDetailResponse

@Entity(tableName = "movie_detail")
data class MovieDetail(
    @PrimaryKey
    @ColumnInfo("movie_id")
    val movieId: Long,

    @ColumnInfo("budget")
    val budget: Long,

    @ColumnInfo("revenue")
    val revenue: Long
)

fun MovieDetailResponse.toEntity(movieId: Long) =
    MovieDetail(movieId, budget, revenue)