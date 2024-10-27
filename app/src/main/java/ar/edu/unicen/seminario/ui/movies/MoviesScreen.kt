package ar.edu.unicen.seminario.ui.movies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ar.edu.unicen.seminario.ui.MovieViewModel

@Composable
fun moviesScreen(
    viewModel: MovieViewModel,
    goDetails: (MovieUIModel) -> Unit //para que moviesScreen nos indique cuando se quiere nav a otra pantalla
) {
    val isLoading:Boolean by viewModel.loading.collectAsStateWithLifecycle()

    moviesContent(
        isLoading = isLoading,
        movies = movies?.map {it.toUiModel() }.orEmpty(),
        onRefreshLoad = {
            viewModel.getMovies(200)
        },
        onMovieClicked = goDetails


    )
}