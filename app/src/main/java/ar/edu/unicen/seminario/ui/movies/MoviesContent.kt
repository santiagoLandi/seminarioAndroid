package ar.edu.unicen.seminario.ui.movies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unicen.seminario.R

@Composable
fun moviesContent(
    isLoading:Boolean,
    movies: List<MovieUIModel>,
    onRefreshLoad: () -> Unit,
    onLoadMore: () -> Unit, // Función para cargar más películas
    onMovieClicked: (MovieUIModel) -> Unit
){

    Column(
        modifier= Modifier
                  .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                       .width(150.dp),
            enabled = !isLoading,
            onClick = {
                onRefreshLoad()
            }
        ) {
            Text(
                text = stringResource(id = R.string.loadMovies)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (isLoading){
            CircularProgressIndicator()
        }else{
            LazyColumn(
                modifier = Modifier.fillMaxWidth()) {

                itemsIndexed(movies){ index,movie ->
                    movieItem(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        tittle = movie.title,
                        releaseDate = movie.releaseDate,
                        posterPath = movie.posterPath,
                        onClick = {
                            onMovieClicked(movie)
                        }
                    )
                    // Llamada a cargar más películas cuando quedan pocos elementos
                    if (index >= movies.size - 5 && !isLoading) {
                        onLoadMore()
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun movieContentPreview(){
    moviesContent(
        isLoading = false,
        movies = listOf(
            MovieUIModel(
                id = 1,
                title = "Scarface",
                releaseDate = "02/01/1979",
                posterPath = ""
            ),
            MovieUIModel(
                id = 2,
                title = "Armagedon",
                releaseDate = "05/08/2000",
                posterPath = ""
            ),
            MovieUIModel(
                id = 3,
                title = "Bad Boys",
                releaseDate = "01/08/2006",
                posterPath = ""
            ),
            MovieUIModel(
                id = 4,
                title = "El justiciero",
                releaseDate = "20/06/2012",
                posterPath = ""
            )
        ),
        onRefreshLoad = {},
        onLoadMore = {},
        onMovieClicked = {}
    )
}