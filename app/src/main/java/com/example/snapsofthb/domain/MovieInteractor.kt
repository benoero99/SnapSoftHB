package com.example.snapsofthb.domain

import androidx.core.net.toUri
import com.example.snapsofthb.network.apimodel.MoviesResult
import com.example.snapsofthb.network.NetworkDataSource
import javax.inject.Inject

class MovieInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource
){
    suspend fun getPopularMovies(): MoviesResult {
        return networkDataSource.getPopularMovies()
    }

    suspend fun searchMovies(query: String) : MoviesResult {
        return networkDataSource.searchMovies(query)
    }
}