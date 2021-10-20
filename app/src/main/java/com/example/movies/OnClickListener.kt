package com.example.movies

import com.example.movies.features.movies.data.models.data.MoviesResponse

interface OnClickListener {
    fun onClick(movie:MoviesResponse)
}