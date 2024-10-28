package ar.edu.unicen.seminario.ddl.models

import ar.edu.unicen.seminario.ui.movies.MovieUIModel

data class Movie(
    val id: Int,  // Agrega el campo id
    val title: String,
    val releaseDate: String,
    val overview: String,
    val posterPath: String
)

fun Movie.toUiModel(): MovieUIModel {
    return MovieUIModel(
        id = id,  // Asegúrate de pasar el ID
        title = title,
        releaseDate = releaseDate,
        posterPath = posterPath
    )
}
