package ar.edu.unicen.seminario.ddl.data

import ar.edu.unicen.seminario.ddl.models.ActivityRecommendation
import javax.inject.Inject

class BoredRepository @Inject constructor(
    private val remoteDataSource: BoredRemoteDataSource
) {

    suspend fun getRecommendation(
        participants:Int
    ):ActivityRecommendation?{
        return remoteDataSource.getRecommendation(participants)
    }
}