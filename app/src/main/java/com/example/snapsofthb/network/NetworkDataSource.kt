package com.example.snapsofthb.network

import android.net.Uri
import com.example.snapsofthb.network.apimodel.MoviesResult
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val tmdbApi: TMDBApi
) {
    suspend fun getPopularMovies() : MoviesResult {
        return tmdbApi.getPopularMovies()
    }

    suspend fun searchMovies(query: String): MoviesResult {
        return tmdbApi.searchMovies(query)
    }
}