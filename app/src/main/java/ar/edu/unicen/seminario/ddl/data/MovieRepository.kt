package ar.edu.unicen.seminario.ddl.data

import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) {
    suspend fun getPopularMovies(apiKey: String, page: Int): List<MovieDTO>? {
        return movieRemoteDataSource.getPopularMovies(apiKey, page)?.results
    }

    suspend fun getMovieDetails(id:Int,apiKey: String): MovieDTO?{
        return movieRemoteDataSource.getMovieDetails(id,apiKey)
    }
}

