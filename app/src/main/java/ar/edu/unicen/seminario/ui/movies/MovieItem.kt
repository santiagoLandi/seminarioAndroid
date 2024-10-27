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
    name: String,
    email: String,
    thumbnail:String,
    onClick: () -> Unit
){
    Row (
        modifier = modifier
            .clickable { onClick() },//es para la navegabilidad, el item registra cuando lo clickean para ir a la pantalla con mas info
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        GlideImage(
            modifier = Modifier
                      .size(40.dp),
            model = thumbnail ,
            contentDescription = null
        )
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                color = colorResource(id = R.color.backGreenActivity)
            )
            Text(
                text = email,
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
        name = "Carlos",
        email = "carlos@carlos.com",
        thumbnail = "url",
        onClick = { }
    )
}