package com.example.snapsofthb.ui.movie

import co.zsmb.rainbowcake.withIOContext
import com.example.snapsofthb.domain.MovieInteractor
import com.example.snapsofthb.network.apimodel.MoviesResult
import com.example.snapsofthb.ui.uimodel.MovieUIModel
import javax.inject.Inject

class MoviePresenter @Inject constructor(
    private val movieInteractor: MovieInteractor
) {
    suspend fun getPopularMovies() : MutableList<MovieUIModel> = withIOContext {
        movieInteractor.getPopularMovies().toMovieUIModel()
    }

    suspend fun searchMovie(query: String): MutableList<MovieUIModel> = withIOContext {
        movieInteractor.searchMovies(query).toMovieUIModel()
    }

    private suspend fun MoviesResult.toMovieUIModel(): MutableList<MovieUIModel> {
        val movieList = mutableListOf<MovieUIModel>()
        for (movie in movies) {
            val details = movieInteractor.getMovieDetail(movie.id)
            movieList.add(
                MovieUIModel(
                    title = movie.title,
                    releaseYear = getYear(movie.releaseDate),
                    budget = "Budget: " + getBudget(details.budget),
                    rating = movie.rating.toString(),
                    posterUri = PosterUri(movie.posterImagePath)
                )
            )
        }
        return movieList
    }

    private fun getBudget(budget: Int): String {
        return if(budget==0) {
            "Unknown"
        } else {
            "$$budget"
        }
    }

    private fun getYear(releaseDate: String): String {
        return if(releaseDate.isEmpty()) {
            "Api is trolling me"
        } else {
            releaseDate.substring(0,4)
        }
    }

    private fun PosterUri(uri: String?): String {
        return if(uri == null) {
            "https://upload.wikimedia.org/wikipedia/en/6/60/No_Picture.jpg"
        } else {
            "https://image.tmdb.org/t/p/w500/$uri"
        }


    }
}