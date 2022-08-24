package com.example.snapsofthb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.snapsofthb.databinding.MovieBinding

class MovieAdapter(private val listener: ElementClickListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var data: MutableList<MovieUIModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val itemBinding = MovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val movie = data[position]
        holder.bind(movie)
    }

    override fun getItemCount() = data.size

    fun update(elements: MutableList<MovieUIModel>) {
        data.clear()
        data.addAll(elements)
        notifyDataSetChanged()
    }

    interface ElementClickListener {
        fun onElementClicked(position: Int, holder: ViewHolder)
    }

    inner class ViewHolder(private val itemBinding: MovieBinding) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {
        fun bind(movie: MovieUIModel) {
            itemBinding.movieTitleTV.text = "teszt"
            itemBinding.movieReleaseYearTV.text = "$adapterPosition"
            itemBinding.movieBudgetTV.text = "teszt"
            itemBinding.movieRatingTV.text = "Rating: ${movie.somedata}"
            Glide.with(this.itemView.context).load("https://image.tmdb.org/t/p/w500/ujr5pztc1oitbe7ViMUOilFaJ7s.jpg").into(itemBinding.moviePosterIV)
        }

        override fun onClick(p0: View?) {
            listener.onElementClicked(adapterPosition, this)
        }

    }

}