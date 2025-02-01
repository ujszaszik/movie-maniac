package hu.ujszaszik.moviemaniac.features.filters.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre


@Database(
    entities = [Genre::class],
    version = 1,
    exportSchema = false
)
abstract class GenreDatabase : RoomDatabase() {
    abstract fun dao(): GenreDao
}