package hu.ujszaszik.moviemaniac.features.filters.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@Entity(tableName = "genre")
data class Genre(
    @SerialName("id")
    @PrimaryKey
    val id: Long,

    @SerialName("name")
    val name: String,

    @Transient
    val isSelected: Boolean = false
) {

    fun hasId() = id != MISSING_ID

    companion object {
        private const val MISSING_ID = -1L
        fun all() = Genre(id = MISSING_ID, name = "All")
    }
}