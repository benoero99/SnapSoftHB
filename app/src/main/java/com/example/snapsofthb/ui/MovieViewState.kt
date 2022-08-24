package com.example.snapsofthb.ui

sealed class MovieViewState

object Loading : MovieViewState()

object Ready : MovieViewState()