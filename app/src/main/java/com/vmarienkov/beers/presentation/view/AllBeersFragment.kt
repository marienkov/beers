package com.vmarienkov.beers.presentation.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vmarienkov.beers.App
import com.vmarienkov.beers.R
import com.vmarienkov.beers.presentation.view_model.AllBeersViewModel

class AllBeersFragment : Fragment() {
    lateinit var allBeersViewModel: AllBeersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allBeersViewModel = ViewModelProviders.of(this).get(AllBeersViewModel::class.java)
        allBeersViewModel.getAllBeersUseCase = (activity?.application as App).appModule.getAllBeersUseCase
        lifecycle.addObserver(allBeersViewModel)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_beers, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allBeersViewModel.beersLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("Tag", "size = ${it?.size}")
        })
    }
}