package ar.edu.unicen.seminario.ui.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import ar.edu.unicen.seminario.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun movieScreen(
    title:String,
    releaseDate:String,
    overview:String,
    posterPath: String

){
    Column(
        modifier = Modifier
                   .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        GlideImage(
            modifier = Modifier.size(160.dp),
            model = posterPath,
            contentDescription = null
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id= R.color.brandColor)
        )
        Text(
            text = releaseDate,
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id= R.color.brandColor)
        )
        Text(
            text = overview,
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id= R.color.brandColor)
        )

    }
}