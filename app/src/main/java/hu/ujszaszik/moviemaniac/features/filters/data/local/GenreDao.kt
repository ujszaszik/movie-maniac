package hu.ujszaszik.moviemaniac.features.filters.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import kotlinx.coroutines.flow.Flow

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(list: List<Genre>)

    @Query("SELECT * FROM genre ORDER BY name ASC")
    fun getGenres(): Flow<List<Genre>>

    @Query("SELECT COUNT(*) FROM genre")
    fun getSize(): Int

    @Query("SELECT * FROM genre WHERE isSelected = 1 LIMIT 1")
    fun getSelected(): Flow<Genre?>

    @Query("UPDATE genre SET isSelected = CASE WHEN id = :id THEN 1 ELSE 0 END")
    fun setSelected(id: Long)
}