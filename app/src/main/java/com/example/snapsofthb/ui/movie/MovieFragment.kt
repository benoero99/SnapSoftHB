package com.example.snapsofthb.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.hilt.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.example.snapsofthb.adapter.MovieAdapter
import com.example.snapsofthb.databinding.FragmentMovieBinding
import com.example.snapsofthb.ui.detail.DetailFragment
import com.example.snapsofthb.util.KeyboardUtils
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : RainbowCakeFragment<MovieViewState, MovieViewModel>(), MovieAdapter.ElementClickListener {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMovieBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieAdapter(this)
        binding.moviesList.adapter = adapter


        binding.movieSearcherTIET.setOnEditorActionListener { tv, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.movieSearcherTIET.clearFocus()
                KeyboardUtils.hideKeyboard(activity)
                if(tv.text.toString().isEmpty()) {
                    viewModel.getPopularMovies()
                } else {
                    viewModel.searchMovie(tv.text.toString())
                }
                true
            } else false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun render(viewState: MovieViewState) {
        when(viewState) {
            Loading ->  {
                Toast.makeText(requireContext(), "View is loading", Toast.LENGTH_SHORT).show()
                adapter.clear()
            }
            is Ready -> {
                adapter.update(viewState.moviesResult)
            }
            is Error -> {
                Toast.makeText(requireContext(), viewState.e.message, Toast.LENGTH_SHORT).show()
            }
        }.exhaustive
    }

    override fun onElementClicked(position: Int, holder: MovieAdapter.ViewHolder) {
        navigator?.add(DetailFragment())
    }

}