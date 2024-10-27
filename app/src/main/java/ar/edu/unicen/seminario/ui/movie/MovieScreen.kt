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
    name:String,
    email:String,
    phone:String,
    adress:String,
    image: String,
    thumbnail:String
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
            model = image,
            contentDescription = null
        )
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id= R.color.brandColor)
        )
        Text(
            text = email,
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id= R.color.brandColor)
        )
        Text(
            text = phone,
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id= R.color.brandColor)
        )
        Text(
            text = adress,
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id= R.color.brandColor)
        )

    }
}