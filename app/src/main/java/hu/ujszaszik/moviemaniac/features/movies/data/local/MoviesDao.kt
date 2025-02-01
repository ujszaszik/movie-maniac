package hu.ujszaszik.moviemaniac.features.movies.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(detail: MovieDetail)

    @Query("SELECT * FROM movie_detail WHERE movie_id = :movieId LIMIT 1")
    fun getMovieById(movieId: Long): MovieDetail?
}