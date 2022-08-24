package com.example.snapsofthb.ui

import co.zsmb.rainbowcake.withIOContext
import com.example.snapsofthb.domain.MovieInteractor
import com.example.snapsofthb.network.apimodel.MoviesResult
import javax.inject.Inject

class MoviePresenter @Inject constructor(
    private val movieInteractor: MovieInteractor
) {
    suspend fun getPopularMovies() : MoviesResult = withIOContext {
        movieInteractor.getPopularMovies()
    }
}