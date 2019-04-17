package com.vmarienkov.beers.presentation.view_model

import android.arch.lifecycle.*
import com.vmarienkov.beers.domain.interactor.GetAllBeersUseCase
import com.vmarienkov.beers.domain.model.Beer
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AllBeersViewModel : ViewModel(), LifecycleObserver {
    lateinit var getAllBeersUseCase: GetAllBeersUseCase

    val beersLiveData: MutableLiveData<List<Beer>> = MutableLiveData()
    var getAllBeersJob: Job? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getAllBeersJob = launch {
            val allBeers = getAllBeersUseCase.getAllBeers()
            beersLiveData.postValue(allBeers)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        getAllBeersJob?.cancel()
    }
}