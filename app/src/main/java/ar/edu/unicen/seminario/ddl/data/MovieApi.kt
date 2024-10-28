package ar.edu.unicen.seminario.ddl.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ):Response<MovieResponseDTO>

    @GET("/{id}")
    suspend fun getMovieDetails(
        @Path("id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Response<MovieDTO>


}