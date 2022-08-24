package com.example.snapsofthb.ui

import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.hilt.getViewModelFromFactory
import com.example.snapsofthb.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : RainbowCakeFragment<MovieViewState, MovieViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_movie

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: MovieViewState) {
        when(viewState) {
            Loading -> Toast.makeText(requireContext(), "View is loading", Toast.LENGTH_SHORT).show()
            is Ready -> Toast.makeText(requireContext(), viewState.moviesResult.toString(), Toast.LENGTH_SHORT).show()
        }.exhaustive
    }

}