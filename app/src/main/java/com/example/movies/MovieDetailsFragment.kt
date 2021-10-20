package com.example.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.movies.databinding.FragmentMovieDetailsBinding
import com.example.movies.features.movies.data.models.data.MovieDetail
import com.example.movies.features.movies.data.services.APIService
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDetailsFragment : Fragment() {

    private lateinit var mBinding:FragmentMovieDetailsBinding
    private lateinit var mMovieDetail:MovieDetail


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        mBinding= FragmentMovieDetailsBinding.inflate(inflater,container,false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id= arguments?.getLong(getString(R.string.arg_id),0)
//        val title= arguments?.getString(getString(R.string.arg_title),"")
//        val photo= arguments?.getString(getString(R.string.backdropPath),"")
//        val overview=arguments?.getString(getString(R.string.overview),"")
//        val popularity=arguments?.getString(getString(R.string.popularity),"")
//        val mediaType=arguments?.getString(getString(R.string.mediaType),"")
//        val posterPath=arguments?.getString(getString(R.string.posterPath),"")

        if (id!=null&&id!=0L){
              getMovie(id)
//            setUiMovie(id,title,photo,overview,popularity,mediaType,posterPath)
        }else{
            Toast.makeText(activity,id.toString(),Toast.LENGTH_SHORT).show()
        }

    }

    private fun getMovie(id: Long) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getMovieById("movie/$id?api_key=95644482b1c66a2342c85021908cc3dd")
            val moviesRes = call.body()
            runBlocking {
                if (call.isSuccessful) {
                    //show recyclerview
                    mMovieDetail= moviesRes!!
                    Thread{
                        setUiMovie(mMovieDetail)
                    }.start()
                    Log.i("response", mMovieDetail.toString())
                    println("**-*-*-*-*-*-*-*-*-*-*-*+${mMovieDetail}")
                } else {
                    Log.i("response", "Pinga de mulo")
                    //show error
//                    showError()
                    //  Toast.makeText(this@MainActivity, "No Funciono", Toast.LENGTH_SHORT).show()
                }
            }

//                hideKeyboard()

        }
    }

    private fun setUiMovie(movieDetail: MovieDetail) {
        with(mBinding){
            tvTitle.text = movieDetail.title
            val url:String= "https://image.tmdb.org/t/p/w500/"+movieDetail.posterPath!!
          //  Picasso.get().load(url).into(ivMoviePoster)
            val urlBackDropPath="https://image.tmdb.org/t/p/w500/"+movieDetail.backdropPath!!
           // Picasso.get().load(urlBackDropPath).into(ivMovieThumb)
//            tvGenre.text= mediaType
//            tvRating.text=popularity
//            tvOverview.text=overview
        }
    }


}