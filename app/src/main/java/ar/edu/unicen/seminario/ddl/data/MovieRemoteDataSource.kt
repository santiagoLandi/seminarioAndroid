package ar.edu.unicen.seminario.ddl.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieApi: MovieApi
) {
    suspend fun getPopularMovies(apiKey: String, page: Int): MovieResponseDTO? {
        return withContext(Dispatchers.IO) {
            try {
                val response = movieApi.getPopularMovies(apiKey, page)
                if (response.isSuccessful) {
                    response.body() // Retorna el cuerpo de la respuesta si es exitoso
                } else {
                    // Manejo de error si es necesario
                    null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null // Retorna null en caso de excepción
            }
        }
    }
}
