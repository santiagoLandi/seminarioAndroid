package ar.edu.unicen.seminario.ddl.models

import ar.edu.unicen.seminario.ui.movies.MovieUIModel

data class Movie(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: String
)

fun Movie.toUiModel(): MovieUIModel {
    return MovieUIModel(
        id = id,
        title = title,
        releaseDate = releaseDate,
        posterPath = posterPath
    )
}
