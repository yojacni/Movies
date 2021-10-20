package com.example.movies.features.movies.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.OnClickListener
import com.example.movies.R
import com.example.movies.databinding.ItemMovieBinding
import com.example.movies.features.movies.data.models.data.MoviesResponse
import com.squareup.picasso.Picasso

class MoviesAdapter(private val movies: MutableList<MoviesResponse>, private var listener: OnClickListener) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movies[position]
        holder.bind(item)

        with(holder){
            setListener(item)
            binding.tvName.text= item.title
        }
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemMovieBinding.bind(view)

        val name = binding.tvName
        val date = binding.tvDate

        fun bind(movie: MoviesResponse) {
            name.text = movie.title
            date.text = movie.release_date
            val url:String= "https://image.tmdb.org/t/p/w500/"+movie.poster_path
            Picasso.get().load(url).into(binding.ivMovie)
        }

        fun setListener(movie:MoviesResponse){
            binding.root.setOnClickListener { listener.onClick(movie) }
        }
    }
}