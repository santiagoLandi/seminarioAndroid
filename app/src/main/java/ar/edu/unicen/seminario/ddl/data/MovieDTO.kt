package ar.edu.unicen.seminario.ddl.data

import androidx.annotation.Keep
import ar.edu.unicen.seminario.ui.movies.MovieUIModel
import com.google.gson.annotations.SerializedName

@Keep
data class MovieDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("overview")
    val overview:String,
    @SerializedName("poster_path")
    val posterPath: String // Este campo contendrá el camino de la imagen
)

fun MovieDTO.toUiModel(): MovieUIModel {
    return MovieUIModel(
        id = id,  // Pasa el ID
        title = title,
        releaseDate = releaseDate,
        posterPath = posterPath
    )
}

