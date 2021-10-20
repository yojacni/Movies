package com.example.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.movies.databinding.FragmentMovieDetailsBinding
import com.squareup.picasso.Picasso


class MovieDetailsFragment : Fragment() {

    private lateinit var mBinding:FragmentMovieDetailsBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        mBinding= FragmentMovieDetailsBinding.inflate(inflater,container,false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id= arguments?.getLong(getString(R.string.arg_id),0)
        val title= arguments?.getString(getString(R.string.arg_title),"")
        val photo= arguments?.getString(getString(R.string.backdropPath),"")
        val overview=arguments?.getString(getString(R.string.overview),"")
        val popularity=arguments?.getString(getString(R.string.popularity),"")
        val mediaType=arguments?.getString(getString(R.string.mediaType),"")
        val posterPath=arguments?.getString(getString(R.string.posterPath),"")

        if (id!=null&&id!=0L){
            setUiMovie(id,title,photo,overview,popularity,mediaType,posterPath)

        }else{
            Toast.makeText(activity,id.toString(),Toast.LENGTH_SHORT).show()
        }

    }

    private fun setUiMovie(id: Long, title: String?, photo: String?, overview: String?, popularity: String?, mediaType: String?, posterPath: String?) {
        with(mBinding){
            tvTitle.text = title
            val url:String= "https://image.tmdb.org/t/p/w500/"+photo!!
            Picasso.get().load(url).into(ivMoviePoster)
            val urlBackDropPath="https://image.tmdb.org/t/p/w500/"+posterPath!!
            Picasso.get().load(urlBackDropPath).into(ivMovieThumb)
            tvGenre.text= mediaType
            tvRating.text=popularity
            tvOverview.text=overview
        }
    }


}