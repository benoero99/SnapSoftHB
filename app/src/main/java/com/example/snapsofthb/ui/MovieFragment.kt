package com.example.snapsofthb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.hilt.getViewModelFromFactory
import com.example.snapsofthb.databinding.FragmentMovieBinding
import com.example.snapsofthb.util.KeyboardUtils
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : RainbowCakeFragment<MovieViewState, MovieViewModel>() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMovieBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.certificateListSearcherTIET.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.certificateListSearcherTIET.clearFocus()
                KeyboardUtils.hideKeyboard(activity)
                //viewModel.load()
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
            Loading -> Toast.makeText(requireContext(), "View is loading", Toast.LENGTH_SHORT).show()
            is Ready -> {
                Toast.makeText(requireContext(), viewState.moviesResult.toString(), Toast.LENGTH_SHORT).show()

            }
        }.exhaustive
    }

}