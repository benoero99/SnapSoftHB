package com.example.snapsofthb.ui.detail

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val detailPresenter: DetailPresenter) : RainbowCakeViewModel<DetailViewState>(Loading) {

    fun getDetails(movieId: Int) = execute {
        viewState = try {
            val details = detailPresenter.getDetails(movieId)
            Ready(details)
        } catch (e: Exception) {
            Error(e)
        }

    }
}