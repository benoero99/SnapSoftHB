package com.example.snapsofthb.ui

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val moviePresenter: MoviePresenter): RainbowCakeViewModel<MovieViewState>(
    Loading
) {

    fun load() = execute {
        viewState = Ready
    }

}