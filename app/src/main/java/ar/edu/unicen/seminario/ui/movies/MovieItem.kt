package ar.edu.unicen.seminario.ui.movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import ar.edu.unicen.seminario.R
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun movieItem(
    modifier: Modifier = Modifier,
    tittle: String,
    releaseDate: String,
    posterPath:String,
    onClick: () -> Unit
){
    val baseImageURL = "https://image.tmdb.org/t/p/w500"
    val fullImageURL = baseImageURL + posterPath
    Row (
        modifier = modifier
            .clickable { onClick() },//es para la navegabilidad, el item registra cuando lo clickean para ir a la pantalla con mas info
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        GlideImage(
            modifier = Modifier
                      .size(50.dp),
            model = fullImageURL ,
            contentDescription = null
        )
        Column {
            Text(
                text = tittle,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.backGreen)
            )
            Text(
                text = releaseDate,
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(id = R.color.brandColor)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun movieItemPreview(){
    movieItem(
        modifier = Modifier
                   .fillMaxWidth()
                   .padding(12.dp),
        tittle = "Gladiador",
        releaseDate = "04/03/2001",
        posterPath = "url",
        onClick = { }
    )
}