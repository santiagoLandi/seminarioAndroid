package ar.edu.unicen.seminario.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unicen.seminario.ui.movie.movieScreen
import ar.edu.unicen.seminario.ui.movies.moviesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity: AppCompatActivity() {

    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{

            val navController: NavHostController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "movies"
            ){
                composable(
                    route = "movies"
                ) {
                    moviesScreen(               //cuando hagan click en un item, el item le avisa al contenido, el contenido le avisa al screen y
                        viewModel = viewModel,  // el screen le avisa a nuestro componente de navegacion (en activity) e ir a los detalles.
                                                // Lo idea ahi es pasar un {id} no un movieUIModel. Ya que para mostrar recibimos todos los datos
                                                // por parametro
                        goDetails = {
                            movieUIModel ->   //deberia pasar un id aca
                            navController.navigate(
                                "movie/{movieId}"
                            )
                        }
                    )
                }

                composable(
                    route = "movie/{movieId}" //seria la mejor forma, pasar solo un id
                ) {
                    movieScreen(
                        name = "",
                        email = "",
                        phone = "",
                        adress = "",
                        image = "",
                        thumbnail = ""
                    )
                }
            }

        }
    }
}