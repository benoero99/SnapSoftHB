package com.example.snapsofthb.network.apimodel

import com.google.gson.annotations.SerializedName

data class MoviesResult(
    val page: Int,
    @SerializedName("results")
    val movies: MutableList<Movie>,
    @SerializedName("total_results")
    val movieCount: Int,
    @SerializedName("total_pages")
    val pageCount: Int
)

data class Movie(
    val id: Int,
    @SerializedName("poster_path")
    val posterImagePath: String,
    val adult: Boolean,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    val title: String,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    val popularity: Number,
    @SerializedName("vote_count")
    val voteCount: Int,
    val video: Boolean,
    @SerializedName("vote_average")
    val rating: Number
)