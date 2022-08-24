package com.example.snapsofthb.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.hilt.getViewModelFromFactory
import com.bumptech.glide.Glide
import com.example.snapsofthb.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment constructor(private val movieId: Int) : RainbowCakeFragment<DetailViewState, DetailViewModel>() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDetails(movieId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun render(viewState: DetailViewState) {
        when(viewState) {
            is Error -> {
                Toast.makeText(requireContext(), viewState.e.message, Toast.LENGTH_SHORT).show()
            }
            Loading -> {
                binding.loadingDetailView.show()
            }
            is Ready -> {
                binding.loadingDetailView.hide()
                Log.d("asd",viewState.details.toString())
                binding.detailTitleTV.text = "Title: ${viewState.details.title}"
                binding.genresDetailTV.text = viewState.details.genres
                binding.releaseDateDetailTV.text = viewState.details.releaseDate
                binding.lengthDetailTV.text = viewState.details.length
                binding.budgetDetailTV.text = "Budget: ${viewState.details.budget}"
                binding.ratingCountDetailTV.text = "Total votes: ${viewState.details.voteCount}"
                binding.ratingDetailTV.text = "Rating: ${viewState.details.rating}"
                binding.overviewDetailTV.text = viewState.details.overview
                Glide.with(requireContext()).load(viewState.details.posterUri).into(binding.detailPosterIV)
            }
        }.exhaustive
    }

}