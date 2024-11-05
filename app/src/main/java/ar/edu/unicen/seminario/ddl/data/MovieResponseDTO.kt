package ar.edu.unicen.seminario.ddl.data

import androidx.annotation.Keep

@Keep
data class MovieResponseDTO(
    val page: Int,
    val results: List<MovieDTO>,
    val totalResults: Int,
    val totalPages: Int
)