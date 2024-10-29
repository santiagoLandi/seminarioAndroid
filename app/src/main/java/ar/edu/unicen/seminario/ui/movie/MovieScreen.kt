package ar.edu.unicen.seminario.ui.movie

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ar.edu.unicen.seminario.R
import ar.edu.unicen.seminario.ui.MovieViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun movieScreen(
    id: Int,
    viewModel: MovieViewModel,
    onBack: () -> Unit
) {
    // Obtenemos el estado de los detalles de la película
    val movieDetails by viewModel.movieDetails.collectAsStateWithLifecycle()

    // Lanzamos la solicitud de detalles de la película al cargar la pantalla
    LaunchedEffect(id) {
        viewModel.getMovieDetails(id)
    }
    Log.d("MovieScreen", "Detalles de la película: $movieDetails")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        // Comprobamos si movieDetails tiene los datos de la película
        movieDetails?.let { movie ->
            GlideImage(
                modifier = Modifier.size(350.dp),
                model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
                contentDescription = movie.title
            )
            Text(
                text = movieDetails?.title ?: "Título no disponible",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.brandColor)
            )
            Text(
                text = movieDetails?.releaseDate ?: "Fecha no disponible",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.bodyText)
            )
            Text(
                text = movieDetails?.overview ?: "Descripción no disponible",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.bodyText)
            )
        } ?: run {

            Text(
                text = "Cargando detalles de la película...",
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(id = R.color.brandColor)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBack,
            modifier = Modifier
                       .padding(16.dp)) {
            Text("Volver")
        }
    }
}
