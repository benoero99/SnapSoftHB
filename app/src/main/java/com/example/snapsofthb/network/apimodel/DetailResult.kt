package com.example.snapsofthb.network.apimodel

import com.google.gson.annotations.SerializedName

data class DetailResult(
    var id: Int,
    var budget: Int?,
    var genres: List<Genre>,
    @SerializedName("original_language")
    var originalLanguage: String,
    @SerializedName("original_title")
    var originalTitle: String,
    var overview: String,
    @SerializedName("poster_path")
    var posterImagePath: String,
    @SerializedName("release_date")
    var releaseDate: String,
    var title: String,
    @SerializedName("vote_average")
    var rating: Number,
    @SerializedName("vote_count")
    var voteCount: Int,
    var runtime: Int?
)

data class Genre(
    var id: Int,
    var name: String
)


