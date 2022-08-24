package com.example.snapsofthb.ui.detail

import co.zsmb.rainbowcake.withIOContext
import com.example.snapsofthb.domain.MovieInteractor
import com.example.snapsofthb.network.apimodel.DetailResult
import com.example.snapsofthb.network.apimodel.Genre
import com.example.snapsofthb.ui.uimodel.DetailUIModel
import java.lang.StringBuilder
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val movieInteractor: MovieInteractor
) {
    suspend fun getDetails(movieId: Int): DetailUIModel = withIOContext {
        movieInteractor.getMovieDetail(movieId).toDetailUIModel()
    }

    private fun DetailResult.toDetailUIModel(): DetailUIModel {
        return DetailUIModel(
            title = title,
            posterUri = posterUri(posterImagePath),
            rating = rating.toString(),
            genres = genreConcat(genres),
            budget = getBudget(budget),
            overview = overview,
            releaseDate = releaseDate,
            voteCount = voteCount.toString(),
            length = formatMovieLength(runtime)
        )
    }

    private fun posterUri(uri: String?): String {
        return if(uri == null) {
            "https://upload.wikimedia.org/wikipedia/en/6/60/No_Picture.jpg"
        } else {
            "https://image.tmdb.org/t/p/w500/$uri"
        }
    }

    private fun genreConcat(list: List<Genre>): String {
        if(list.isEmpty()) {
            return "No genre given"
        }
        val stringBuilder = StringBuilder()
        list.forEach {
            stringBuilder.append("${it.name}, ")
        }
        stringBuilder.setLength(stringBuilder.length - 2)
        return stringBuilder.toString()
    }

    private fun getBudget(budget: Int?): String {
        return if(budget == null || budget==0) {
            "Unknown"
        } else {
            "$$budget"
        }
    }

    private fun formatMovieLength(length: Int?): String {
        if (length == null) {
            return "Unknown"
        }
        val hours = length / 60
        val minutes = length % 60
        return "${hours}h ${minutes}m"
    }

}