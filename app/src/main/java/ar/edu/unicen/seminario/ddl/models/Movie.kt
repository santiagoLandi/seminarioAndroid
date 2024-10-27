package ar.edu.unicen.seminario.ddl.models

import ar.edu.unicen.seminario.ui.movies.MovieUIModel

data class Movie(
    val name: String,
    val email: String,
    val phone: String,
    val address: String,
    val imageUrl: String,
    val thumbnailUrl: String
)

fun Movie.toUiModel(): MovieUIModel {
    return MovieUIModel(
        name = this.name,
        email = this.email,
        phone = this.phone,
        adress = this.address,
        image = this.imageUrl,
        thumbnail = this.thumbnailUrl
    )
}