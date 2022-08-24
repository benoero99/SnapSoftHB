package com.example.snapsofthb.ui.movie

import com.example.snapsofthb.ui.uimodel.MovieUIModel

sealed class MovieViewState

object Loading : MovieViewState()

data class Error(
    val e: Exception
    ) : MovieViewState()

data class Ready(
    val moviesResult: MutableList<MovieUIModel>
    ) : MovieViewState()