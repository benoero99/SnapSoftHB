package com.example.snapsofthb.ui

import com.example.snapsofthb.network.apimodel.MoviesResult

sealed class MovieViewState

object Loading : MovieViewState()

data class Ready(
    val moviesResult: MoviesResult
) : MovieViewState()