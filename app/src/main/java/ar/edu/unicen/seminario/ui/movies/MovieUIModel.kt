package ar.edu.unicen.seminario.ui.movies

import ar.edu.unicen.seminario.ddl.models.Movie

class MovieUIModel(
    val name:String,
    val email: String,
    val phone: String,
    val adress:String,
    val image: String,
    val thumbnail: String
) {

    companion object{
        fun Movie.toUiModel():MovieUIModel{
            return MovieUIModel(
                name = name,
                email = email,
                phone = phone,
                adress = this.address,
                image = this.imageUrl,
                thumbnail = this.thumbnailUrl
            )
        }
    }




}