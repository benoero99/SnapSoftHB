package com.example.snapsofthb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.snapsofthb.databinding.MovieBinding
import com.example.snapsofthb.ui.uimodel.MovieUIModel

class MovieAdapter(private val listener: ElementClickListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var data: MutableList<MovieUIModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = MovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = data[position]
        holder.bind(movie)
    }

    override fun getItemCount() = data.size

    fun update(elements: MutableList<MovieUIModel>) {
        data.addAll(elements)
        notifyDataSetChanged()
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    interface ElementClickListener {
        fun onElementClicked(position: Int, holder: ViewHolder)
    }

    inner class ViewHolder(private val itemBinding: MovieBinding) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {
        fun bind(movie: MovieUIModel) {
            itemView.setOnClickListener(this)
            itemBinding.movieTitleTV.text = movie.title
            itemBinding.movieReleaseYearTV.text = movie.releaseYear
            itemBinding.movieBudgetTV.text = movie.budget
            itemBinding.movieRatingTV.text = "Rating: ${movie.rating}"
            Glide.with(this.itemView.context).load(movie.posterUri).into(itemBinding.moviePosterIV)
        }

        override fun onClick(p0: View?) {
            listener.onElementClicked(adapterPosition, this)
        }

    }

}