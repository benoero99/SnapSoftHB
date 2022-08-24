package com.example.snapsofthb.domain

import com.example.snapsofthb.network.apimodel.MoviesResult
import com.example.snapsofthb.network.NetworkDataSource
import javax.inject.Inject

class MovieInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource
){
    suspend fun getPopularMovies(): MoviesResult {
        return networkDataSource.getPopularMovies()
    }
}