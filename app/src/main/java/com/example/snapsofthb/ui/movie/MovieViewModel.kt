package com.example.snapsofthb.ui.movie

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.example.snapsofthb.ui.uimodel.MovieUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val moviePresenter: MoviePresenter): RainbowCakeViewModel<MovieViewState>(
    Default
) {

    fun searchMovie(query: String) = execute {
        viewState = Loading
        val movies: MutableList<MovieUIModel>
        viewState = try {
            movies = moviePresenter.searchMovie(query)
            Ready(movies)
        } catch (e: Exception) {
            Error(e)
        }

    }

    fun getPopularMovies() = execute {
        viewState = Loading
        val movies: MutableList<MovieUIModel>
        try {
            movies = moviePresenter.getPopularMovies()
            viewState = Ready(movies)
        } catch (e: Exception) {
            viewState = Error(e)
        }
    }

}