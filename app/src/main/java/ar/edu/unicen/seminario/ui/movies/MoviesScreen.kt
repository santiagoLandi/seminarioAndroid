package ar.edu.unicen.seminario.ui.movies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ar.edu.unicen.seminario.ddl.data.toUiModel
import ar.edu.unicen.seminario.ui.MovieViewModel

@Composable
fun moviesScreen(
    viewModel: MovieViewModel,
    goDetails: (MovieUIModel) -> Unit
) {
    val isLoading:Boolean by viewModel.loading.collectAsStateWithLifecycle()
    val movies by viewModel.movies.collectAsStateWithLifecycle()

    moviesContent(
        isLoading = isLoading,
        movies = movies?.map {it.toUiModel() }.orEmpty(),
        onRefreshLoad = {
            viewModel.getMovies()
        },
        onLoadMore = { viewModel.getMovies() },
        onMovieClicked = goDetails


    )
}