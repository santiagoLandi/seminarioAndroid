package ar.edu.unicen.seminario.ui.movies

import ar.edu.unicen.seminario.ddl.models.Movie

class MovieUIModel(
    val id: Int,  // Agrega el campo id
    val title: String,
    val releaseDate: String,
    val posterPath: String
) {
    // Aquí puedes agregar métodos adicionales si es necesario
}
