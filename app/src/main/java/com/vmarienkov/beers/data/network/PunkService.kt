package com.vmarienkov.beers.data.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PunkService {
    @GET("beers/")
    fun getBeers(): Deferred<List<Response>>
}