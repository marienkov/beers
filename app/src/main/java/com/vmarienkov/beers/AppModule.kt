package com.vmarienkov.beers

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.vmarienkov.beers.data.network.PunkService
import com.vmarienkov.beers.data.repository.BeersRepositoryImpl
import com.vmarienkov.beers.domain.interactor.GetAllBeersUseCase
import com.vmarienkov.beers.domain.repository.BeersRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class AppModule(private val context: Context) {

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .build()
    }

    val punkService: PunkService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        retrofit.create(PunkService::class.java)
    }

    val beersRepository: BeersRepository = BeersRepositoryImpl(punkService)

    val getAllBeersUseCase: GetAllBeersUseCase = GetAllBeersUseCase(beersRepository)
}