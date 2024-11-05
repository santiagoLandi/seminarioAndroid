package ar.edu.unicen.seminario.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unicen.seminario.BuildConfig
import ar.edu.unicen.seminario.ddl.data.MovieDTO
import ar.edu.unicen.seminario.ddl.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor (
    private val movieRepository: MovieRepository
):ViewModel(){
    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow(false)
    val error = _error.asStateFlow()

    private val _movies = MutableStateFlow<List<MovieDTO>?>(null)
    val movies = _movies.asStateFlow()

    private val api = BuildConfig.THE_MOVIE_DB_API_KEY
    private var currentPage:Int=1

    private val _movieDetails = MutableStateFlow<MovieDTO?>(null)
    val movieDetails = _movieDetails.asStateFlow()

    fun getMovies(
    ){
        viewModelScope.launch {
            _loading.value = true
            _error.value = false
            _movies.value = null

            val popularMovies = movieRepository.getPopularMovies(api, currentPage)

            delay(500)

            if (popularMovies != null) {
                _movies.value = _movies.value.orEmpty() + popularMovies
                currentPage++
            }


            _loading.value = false
            _movies.value = popularMovies
            _error.value = movies == null

        }
    }

    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _movieDetails.value = movieRepository.getMovieDetails(movieId,api)
        }
    }
}