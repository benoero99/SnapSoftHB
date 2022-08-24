package com.example.snapsofthb.ui.detail

import com.example.snapsofthb.ui.uimodel.DetailUIModel

sealed class DetailViewState

object Loading : DetailViewState()

data class Error(
    val e: Exception
) : DetailViewState()

data class Ready(
    val details: DetailUIModel
) : DetailViewState()