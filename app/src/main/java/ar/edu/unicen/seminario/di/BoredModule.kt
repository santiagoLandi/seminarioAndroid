package ar.edu.unicen.seminario.di

import ar.edu.unicen.seminario.ddl.data.BoredApi
import ar.edu.unicen.seminario.ddl.data.BoredRemoteDataSource
import ar.edu.unicen.seminario.ddl.data.BoredRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BoredModule {

    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
               .baseUrl("https://apis.scrimba.com/bored/api/")
               .addConverterFactory(GsonConverterFactory.create())
               .build()
    }

    @Provides
    fun providesBoredApi(
        retrofit: Retrofit
    ):BoredApi{
        return retrofit.create(BoredApi::class.java)//crea una instancia de la interfaz con la implementacion del metodo
    }
}