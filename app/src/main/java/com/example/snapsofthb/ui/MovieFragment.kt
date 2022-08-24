package com.example.snapsofthb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.hilt.getViewModelFromFactory
import com.example.snapsofthb.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : RainbowCakeFragment<MovieViewState, MovieViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_movie

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: MovieViewState) {
        when(viewState) {
            Loading -> Toast.makeText(requireContext(), "View is loading", Toast.LENGTH_SHORT).show()
            Ready -> Toast.makeText(requireContext(), "View is loaded successfully", Toast.LENGTH_SHORT).show()
        }.exhaustive
    }

}