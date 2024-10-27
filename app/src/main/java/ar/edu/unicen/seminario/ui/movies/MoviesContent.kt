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
                text = stringResource(id = R.string.loadUsers)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (isLoading){
            CircularProgressIndicator()
        }else{
            LazyColumn(
                modifier = Modifier.fillMaxWidth()) {

                items(movies){ movie ->
                    movieItem(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        name = movie.name,
                        email = movie.email,
                        thumbnail = movie.thumbnail,
                        onClick = {
                            onMovieClicked(movie)
                        }
                    )
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
                name = "Carlos Sánchez",
                email = "carlos.sanchez@example.com",
                phone = "+1234567890",
                adress = "123 Calle Falsa, Ciudad",
                image = "https://example.com/image1.jpg",
                thumbnail = "https://example.com/thumbnail1.jpg"
            ),
            MovieUIModel(
                name = "María López",
                email = "maria.lopez@example.com",
                phone = "+0987654321",
                adress = "456 Avenida Real, Ciudad",
                image = "https://example.com/image2.jpg",
                thumbnail = "https://example.com/thumbnail2.jpg"
            ),
            MovieUIModel(
                name = "Juan Pérez",
                email = "juan.perez@example.com",
                phone = "+1122334455",
                adress = "789 Boulevard Central, Ciudad",
                image = "https://example.com/image3.jpg",
                thumbnail = "https://example.com/thumbnail3.jpg"
            ),
            MovieUIModel(
                name = "Ana Martínez",
                email = "ana.martinez@example.com",
                phone = "+5566778899",
                adress = "1011 Paseo de la Paz, Ciudad",
                image = "https://example.com/image4.jpg",
                thumbnail = "https://example.com/thumbnail4.jpg"
            )
        ),
        onRefreshLoad = {},
        onMovieClicked = {}
    )
}