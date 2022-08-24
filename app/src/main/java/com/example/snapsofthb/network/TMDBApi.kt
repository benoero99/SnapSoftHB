package com.example.snapsofthb.network

import android.net.Uri
import com.example.snapsofthb.network.apimodel.MoviesResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
    @GET("movie/popular?api_key=86d5c00ba4de5bbc45f600df22dc125c")
    suspend fun getPopularMovies() : MoviesResult

    @GET("search/movie?api_key=86d5c00ba4de5bbc45f600df22dc125c")
    suspend fun searchMovies(@Query("query") query: String): MoviesResult
}