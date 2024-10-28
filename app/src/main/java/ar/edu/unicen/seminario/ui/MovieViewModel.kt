package ar.edu.unicen.seminario.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unicen.seminario.BuildConfig
import ar.edu.unicen.seminario.ddl.data.MovieDTO
import ar.edu.unicen.seminario.ddl.data.MovieRepository
import ar.edu.unicen.seminario.ddl.models.Movie
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

    private val apiKey = BuildConfig.THE_MOVIE_DB_API_KEY
    private var currentPage:Int=1

    fun getMovies(
    ){
        viewModelScope.launch {
            _loading.value = true
            _error.value = false
            _movies.value = null

            val popularMovies = movieRepository.getPopularMovies(apiKey, currentPage)

            delay(500)

            if (popularMovies != null) {
                // Combina la lista actual de películas con la nueva
                _movies.value = _movies.value.orEmpty() + popularMovies
                currentPage++ // Aumenta el número de página para la próxima solicitud
            }


            _loading.value = false
            _movies.value = popularMovies
            _error.value = movies == null

        }
    }
}