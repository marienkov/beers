package com.vmarienkov.beers.data.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PunkService {
    @GET("v2/beers")
    fun getBeers(): Deferred<List<Response>>
}