package com.vmarienkov.beers.data.repository

import com.vmarienkov.beers.data.network.PunkService
import com.vmarienkov.beers.data.network.Response
import com.vmarienkov.beers.domain.model.Beer
import com.vmarienkov.beers.domain.repository.BeersRepository

class BeersRepositoryImpl(val punkService: PunkService) : BeersRepository {
    override suspend fun getAllBeers(): List<Beer> {
        val response = punkService.getBeers().await()
        return response.map(this::toBeer)
    }

    private fun toBeer(response: Response): Beer {
        return response.run { Beer(id, image_url, description) }
    }
}