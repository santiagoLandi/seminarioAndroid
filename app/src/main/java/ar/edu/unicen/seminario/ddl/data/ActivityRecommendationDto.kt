package ar.edu.unicen.seminario.ddl.data

import androidx.annotation.Keep
import ar.edu.unicen.seminario.ddl.models.ActivityRecommendation
import ar.edu.unicen.seminario.ddl.models.ActivityRecommendationInfo
import com.google.gson.annotations.SerializedName
@Keep
class ActivityRecommendationDto(
    @SerializedName("activity")//se utiliza para mapear los datos y que se le asigne dicho valor de la respuesta de la api
    val activity: String,
    @SerializedName("accessibility")// es buena practica indicar los nombres con los q se va a serializar
    val accessibility:Double,
    @SerializedName("type")
    val type:String,
    @SerializedName("participants")
    val participants:Int,
    @SerializedName("price")
    val price:Double,
    @SerializedName("link")
    val link:String,
    @SerializedName("key")
    val key:String
){
    fun toActivityRecommendation(): ActivityRecommendation{
        return ActivityRecommendation(
            id = key,
            activity=activity,
            info = ActivityRecommendationInfo(
                type=type,
                participants=participants,
                price=price,
                accessibility = accessibility,
                link = link
            )
        )
    }
}