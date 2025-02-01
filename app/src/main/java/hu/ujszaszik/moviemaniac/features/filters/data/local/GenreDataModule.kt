package hu.ujszaszik.moviemaniac.features.filters.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenreDataModule {

    private const val DATABASE_NAME = "Genre_DB"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GenreDatabase {
        return Room.databaseBuilder(
            context,
            GenreDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}