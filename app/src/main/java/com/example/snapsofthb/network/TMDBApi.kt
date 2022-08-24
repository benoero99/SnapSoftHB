package com.example.snapsofthb.network

import com.example.snapsofthb.network.apimodel.MoviesResult
import retrofit2.http.GET

interface TMDBApi {

    @GET("https://api.themoviedb.org/3/movie/popular?api_key=86d5c00ba4de5bbc45f600df22dc125c")
    suspend fun getPopularMovies() : MoviesResult
}