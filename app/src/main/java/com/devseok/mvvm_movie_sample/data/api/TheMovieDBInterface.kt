package com.devseok.mvvm_movie_sample.data.api

import com.devseok.mvvm_movie_sample.data.vo.MovieDetails
import com.devseok.mvvm_movie_sample.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {


    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int) : Single<MovieResponse>

}