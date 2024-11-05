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
                startDestination = "movie"
            ){
                composable(
                    route = "movie"
                ) {
                    moviesScreen(
                        viewModel = viewModel,
                        goDetails = { movieUIModel ->
                            navController.navigate("movie/${movieUIModel.id}")
                        }
                    )
                }

                composable(
                    route = "movie/{movieId}"
                ) { backStackEntry ->
                    val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: return@composable
                    movieScreen(
                        id = movieId,
                        viewModel = viewModel,
                        onBack = { navController.popBackStack() }
                    )
                }
            }

        }
    }
}