package com.vmarienkov.beers.domain.repository

import com.vmarienkov.beers.domain.model.Beer

interface BeersRepository {
    suspend fun getAllBeers(): List<Beer>
}