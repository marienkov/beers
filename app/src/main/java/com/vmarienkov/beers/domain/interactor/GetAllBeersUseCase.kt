package com.vmarienkov.beers.domain.interactor

import com.vmarienkov.beers.domain.model.Beer
import com.vmarienkov.beers.domain.repository.BeersRepository

class GetAllBeersUseCase(private val beersRepository: BeersRepository) {
    suspend fun getAllBeers(): List<Beer> {
        return beersRepository.getAllBeers()
    }
}