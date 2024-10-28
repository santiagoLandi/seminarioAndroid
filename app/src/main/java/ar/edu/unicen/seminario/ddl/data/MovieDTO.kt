package ar.edu.unicen.seminario.ddl.data

import androidx.annotation.Keep
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

