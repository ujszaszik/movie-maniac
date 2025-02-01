package hu.ujszaszik.moviemaniac.features.movies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [MovieDetail::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun dao(): MoviesDao
}